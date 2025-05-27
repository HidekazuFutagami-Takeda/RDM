/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import jp.co.takeda.rdm.common.BaseDTO;
import jp.co.takeda.rdm.common.BaseInfoHolder;
import jp.co.takeda.rdm.common.BaseService;
import jp.co.takeda.rdm.common.LoginInfo;
import jp.co.takeda.rdm.dto.CatDeptsComboDataList;
import jp.co.takeda.rdm.dto.NC204DTO;
import jp.co.takeda.rdm.dto.NC209DTO;
import jp.co.takeda.rdm.entity.SRdmDmcMstDeptEntity;
import jp.co.takeda.rdm.entity.SRdmJkrSosInsAbbrNameEntiry;
import jp.co.takeda.rdm.entity.join.MRdmParamMstEntity;

import jp.co.takeda.rdm.util.AppMethods;
import jp.co.takeda.rdm.util.RdmConstantsData;
import jp.co.takeda.rdm.util.StringUtils;
import jp.co.takeda.rdm.entity.join.SelectDeptListEntityRDM;
import jp.co.takeda.rdm.entity.join.SelectHenkanListEntity;
import jp.co.takeda.rdm.entity.join.SelectNC209MainDataEntity;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;



/**
 * Serviceクラス（NC204)
 * @generated
 */
@Named
public class NC204Service extends BaseService {

    /**
     * ログインスタンス
     * @generated
     */
    private static Log log = LogFactory.getLog(NC204Service.class);

    //略式漢字施設名
    private void  insAbbrNameDrop(NC204DTO indto) {
        // START UOC
    	if(StringUtils.isEmpty(indto.getParamInsNo())) {
    		indto.setInsAbbrName("");
    		indto.setAllCheck(true);//初期状態のフラグ管理。ここをoffにすると検索しなくなる？
    	}else {
    		SRdmJkrSosInsAbbrNameEntiry sRdmJkrSosAddrEntiry = new SRdmJkrSosInsAbbrNameEntiry();
    		sRdmJkrSosAddrEntiry.setInsNo(indto.getParamInsNo());
    		List<SRdmJkrSosInsAbbrNameEntiry> jkrSosAddrMap = dao.select(sRdmJkrSosAddrEntiry);
	    	if(CollectionUtils.isEmpty(jkrSosAddrMap)) {
	        	indto.setInsAbbrName("");
	        }else{
	    		indto.setInsAbbrName(jkrSosAddrMap.get(0).getInsAbbrName());
	       	}
    	}
        // END UOC
    }

    /**
     * イベント処理
     * @param indto NC204DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO init(NC204DTO indto) {
        BaseDTO outdto = indto;
        insAbbrNameDrop(indto);
        // START UOC

        //初期表示画面フラグ = 1(初期化)
        indto.setPageFlg(1);

        // ページ数(現在:１ページ目から)
        indto.setPageCntCur(1);

        //最大件数（エラーチェック用）をパラメータから取得
        if(indto.getMaxPageCnt() == null) {
        	MRdmParamMstEntity mRdmParamMstEntity = new MRdmParamMstEntity();
        	mRdmParamMstEntity.setParamName(RdmConstantsData.PARAM_NAME_MAX_ROWNUM);
        	mRdmParamMstEntity.setDelFlg("0");

        	List<MRdmParamMstEntity> mRdmParamMstEntityList = dao.selectByValue(mRdmParamMstEntity);
        	if(mRdmParamMstEntityList.size() > 0) {
        		String value = mRdmParamMstEntityList.get(0).getValue();
        		indto.setMaxPageCnt(Integer.parseInt(value));
        	}else {
        		indto.setMaxPageCnt(1000);
        	}
        }

        //1画面内の表示件数をパラメータから取得
        if(indto.getPageRowNum() == null) {
        	MRdmParamMstEntity mRdmParamMstEntity2 = new MRdmParamMstEntity();
        	mRdmParamMstEntity2.setParamName(RdmConstantsData.PARAM_NAME_NC204_ROWNUM);
        	mRdmParamMstEntity2.setDelFlg("0");

        	List<MRdmParamMstEntity> mRdmParamMstEntityList2 = dao.selectByValue(mRdmParamMstEntity2);
        	if(mRdmParamMstEntityList2.size() > 0) {
        		String value = mRdmParamMstEntityList2.get(0).getValue();
        		indto.setPageRowNum(Integer.parseInt(value));
        	}else {
               	mRdmParamMstEntity2.setParamName(RdmConstantsData.PARAM_NAME_PAGE_ROWNUM);
               	mRdmParamMstEntityList2 = dao.selectByValue(mRdmParamMstEntity2);
            	if(mRdmParamMstEntityList2.size() > 0) {
            		String value = mRdmParamMstEntityList2.get(0).getValue();
            		indto.setPageRowNum(Integer.parseInt(value));
            	}else {
            		indto.setPageRowNum(100);
            	}
        	}
        }

        //施設固定コードがあるかの判定 ある場合は検索を行う。ない場合は検索せずに画面を表示する。
        if(!StringUtils.isEmpty(indto.getParamInsNo())) {
            //検索を行う
            outdto = search(indto);
        }
        // END UOC
        return outdto;
    }



    /**
     * イベント処理
     * @param indto NC204DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO search(NC204DTO indto) {
    	LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();
        BaseDTO outdto = indto;
        insAbbrNameDrop(indto);
        // START UOC
        //検索条件_施設名（全角）



        //一覧検索件数取得の検索条件の設定
      SelectDeptListEntityRDM paramEntity = new SelectDeptListEntityRDM();
      SelectDeptListEntityRDM paramEntity2 = new SelectDeptListEntityRDM(indto.getSearchInput());
      paramEntity.setScreenId(indto.getBackScreenId());

      //入力_検索文字列  入力バーに入れられた値がnull、""でないかのチェック。
      if(indto.getSearchInput() == null) {
      	    paramEntity.setSearchInput(null);
      	    paramEntity.setInSearchInput("");
      }else if(indto.getSearchInput().equals("")) {
        	paramEntity.setSearchInput(null);
          	paramEntity.setInSearchInput("");
      }else {
    	  if (indto.getSearchInput().isEmpty()) {
          	indto.setSearchInput(null);
          }else {
    	    paramEntity.setSearchInput(indto.getSearchInput());
    	    paramEntity.setInSearchInput(indto.getSearchInput());
          //paramEntity2.setSearchInput(indto.getSearchInput());    //入力文字の変換部
          //paramEntity2.setInSearchInput(indto.getSearchInput());
          //SelectDeptListEntityRDM selectCntEntity2 = (SelectDeptListEntityRDM)dao.select(paramEntity2).get(0);
          //paramEntity.setSearchInput(StringUtils.setEmptyToNull(selectCntEntity2.getSearchInput()));
          //paramEntity.setInSearchInput(selectCntEntity2.getSearchInput());
          }
      }
        //入力_SELECT区分 (パラメータ1)
        paramEntity.setInSelectKbn(0);
        //入力_施設固定コード (パラメータ2)
        paramEntity.setInInsNo(indto.getParamInsNo());
        paramEntity.setInsNo(indto.getParamInsNo());
        //入力_所属部科名カナ(パラメータ3)
        //paramEntity.setInDeptKn(StringUtils.setEmptyToNull(AppMethods.zKanaToHKana(indto.getKensakuKana())));
        //入力_所属部科名漢字 (パラメータ4)
        //paramEntity.setInDeptKj(StringUtils.setEmptyToNull(indto.getKensakuKanj()));
        //入力_全所属部科チェックボックス(パラメータ5)
        paramEntity.setAllCheck(indto.getAllCheck());


        //画面初期表示時の所属部科一覧を取得する
        //SelectDeptListEntity selectCntEntity = (SelectDeptListEntity)dao.select(paramEntity).get(0);
        //SelectDeptListEntityRDM selectCntEntity = (SelectDeptListEntityRDM)dao.select(paramEntity).get(0);

        //ページャー情報設定
        //indto.initPageInfo(indto.getPageCntCur(), selectCntEntity.getRecCnt(), 20);

		List<SelectDeptListEntityRDM> mainCntEntityList = dao.select(paramEntity);

		//件数なので必ず1レコード取得される
        indto.setPageCnt(mainCntEntityList.get(0).getRecCnt());

        //入力_SELECT区分 (パラメータ1)
        paramEntity.setInSelectKbn(1);
        //共通　明細行番号(開始)を生成
        indto.initPageInfo(indto.getPageCntCur(), indto.getPageCnt(), indto.getPageRowNum());
        paramEntity.setInOffset(indto.getLineCntStart() - 1);//現ページのオフセット値
        paramEntity.setInLimit(indto.getPageRowNum());//1ページ件数

        List<CatDeptsComboDataList> catDeptsComboDataList = new ArrayList<CatDeptsComboDataList>();

            //画面初期表示時の帳票一覧を取得する
        List<SelectDeptListEntityRDM> deptListEntity = dao.select(paramEntity);

        //最大件数エラーチェック
        if (checkSearchResults(loginInfo, indto, false)) {
        	indto.setPageFlg(1);
        	return outdto;
        }

        if(paramEntity.getScreenId().equals("ND011")) {
        	for (SelectDeptListEntityRDM entiry : deptListEntity) {
        		CatDeptsComboDataList dataRecord = new CatDeptsComboDataList();

        		// 所属部科コード
        		dataRecord.setDeptCode(entiry.getDeptCode());

        		// 所属部科名漢字
        		dataRecord.setDeptKj(entiry.getDeptKj()); /*setDeptCode部分を修正している(DepjtK)*/

        		catDeptsComboDataList.add(dataRecord);
        	}
        }else if(paramEntity.getScreenId().equals("ND012")) {
        	for (SelectDeptListEntityRDM entiry : deptListEntity) {
        		CatDeptsComboDataList dataRecord = new CatDeptsComboDataList();

        		// 所属部科コード
        		dataRecord.setDeptCode(entiry.getDeptCode());

        		// 所属部科名漢字
        		dataRecord.setDeptKj(entiry.getDeptKj()); /*setDeptCode部分を修正している(DepjtK)*/

        		catDeptsComboDataList.add(dataRecord);
        	}
        }else if(paramEntity.getScreenId().equals("ND101")) {
        	for (SelectDeptListEntityRDM entiry : deptListEntity) {
        		CatDeptsComboDataList dataRecord = new CatDeptsComboDataList();

        		// 所属部科コード
        		dataRecord.setDeptCode(entiry.getDeptCode());

        		// 所属部科名カナ
        		dataRecord.setDeptKn(entiry.getDeptKn()); /*setDeptCode部分を修正している(DeptKn)*/

        		// 所属部科名漢字
        		dataRecord.setDeptKj(entiry.getDeptKj()); /*setDeptCode部分を修正している(DepjtK)*/

        		catDeptsComboDataList.add(dataRecord);
        	}
        }else if(paramEntity.getScreenId().equals("ND102")) {
        	for (SelectDeptListEntityRDM entiry : deptListEntity) {
        		CatDeptsComboDataList dataRecord = new CatDeptsComboDataList();

        		// 所属部科コード
        		dataRecord.setDeptCode(entiry.getDeptCode());

        		// 所属部科名カナ
        		dataRecord.setDeptKn(entiry.getDeptKn()); /*setDeptCode部分を修正している(DeptKn)*/

        		// 所属部科名漢字
        		dataRecord.setDeptKj(entiry.getDeptKj()); /*setDeptCode部分を修正している(DepjtK)*/

        		catDeptsComboDataList.add(dataRecord);
        	}
        }else if(paramEntity.getScreenId().equals("ND103")) {
        	for (SelectDeptListEntityRDM entiry : deptListEntity) {
        		CatDeptsComboDataList dataRecord = new CatDeptsComboDataList();

        		// 所属部科コード
        		dataRecord.setDeptCode(entiry.getDeptCode());

        		// 所属部科名カナ
        		dataRecord.setDeptKn(entiry.getDeptKn()); /*setDeptCode部分を修正している(DeptKn)*/

        		// 所属部科名漢字
        		dataRecord.setDeptKj(entiry.getDeptKj()); /*setDeptCode部分を修正している(DepjtK)*/

        		catDeptsComboDataList.add(dataRecord);
        	}
        }else if(paramEntity.getScreenId().equals("ND014")) {
        	for (SelectDeptListEntityRDM entiry : deptListEntity) {
        		CatDeptsComboDataList dataRecord = new CatDeptsComboDataList();

        		// 所属部科コード
        		dataRecord.setDeptCode(entiry.getDeptCode());

        		// 所属部科名漢字
        		dataRecord.setDeptKj(entiry.getDeptKj()); /*setDeptCode部分を修正している(DepjtK)*/

        		catDeptsComboDataList.add(dataRecord);
        	}
        }else if(paramEntity.getScreenId().equals("NC209")) {
        	for (SelectDeptListEntityRDM entiry : deptListEntity) {
        		CatDeptsComboDataList dataRecord = new CatDeptsComboDataList();

        		// 所属部科コード
        		dataRecord.setDeptCode(entiry.getDeptCode());

        		// 所属部科名漢字
        		dataRecord.setDeptKj(entiry.getDeptKj()); /*setDeptCode部分を修正している(DepjtK)*/

        		catDeptsComboDataList.add(dataRecord);
        	}
        }else if(paramEntity.getScreenId().equals("ND401")) {
        	for (SelectDeptListEntityRDM entiry : deptListEntity) {
        		CatDeptsComboDataList dataRecord = new CatDeptsComboDataList();

        		// 所属部科コード
        		dataRecord.setDeptCode(entiry.getDeptCode());

        		// 所属部科名漢字
        		dataRecord.setDeptKj(entiry.getDeptKj()); /*setDeptCode部分を修正している(DepjtK)*/

        		catDeptsComboDataList.add(dataRecord);
        	}
        }else if(paramEntity.getScreenId().equals("ND001")) {
        	for (SelectDeptListEntityRDM entiry : deptListEntity) {
        		CatDeptsComboDataList dataRecord = new CatDeptsComboDataList();

        		// 所属部科コード
        		dataRecord.setDeptCode(entiry.getDeptCode());

        		// 所属部科名漢字
        		dataRecord.setDeptKj(entiry.getDeptKj()); /*setDeptCode部分を修正している(DepjtK)*/

        		catDeptsComboDataList.add(dataRecord);
        	}
        }

        indto.setParamInsNo(paramEntity.getInInsNo());

        //検索された帳票一覧をDTOに設定する
        indto.setCatDeptsComboDataList(catDeptsComboDataList);
        indto.setPageFlg(0);
        // END UOC

        return outdto;
    }

    /**
     * イベント処理
     * @param indto NC204DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO page(NC204DTO indto) {
        BaseDTO outdto = indto;
        // START UOC

        //検索を行う
        outdto = search(indto);

        // END UOC
        return outdto;
    }

	/*
	 * ６：範囲チェック　
	 * 検索結果件数
	 * エラーありならtrueとし、エラーメッセージをmsgStrにセットする
	 */
	private boolean checkSearchResults(LoginInfo loginInfo, NC204DTO indto, boolean fullchkFlg) {

		boolean errChk = false;
		String msgStr = "";
		String tmpMsgStr = "";

		//６：範囲チェック　
		//検索結果件数
		int pageCnt = 0;
		int maxPageCnt = 0;
		pageCnt = indto.getPageCnt();
		maxPageCnt = indto.getMaxPageCnt();
		if (pageCnt > maxPageCnt) {
			errChk = true;
			tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W002);// 検索結果が表示上限を超えています。検索条件を絞って再検索してください。
			msgStr = msgStr + tmpMsgStr + "\n";
		}
		if (errChk) {// エラーありなのでメッセージをセットする
			indto.setMsgStr(msgStr);
		}
		return errChk;
	}
}