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
import jp.co.takeda.rdm.common.BaseService;
import jp.co.takeda.rdm.dto.CatDeptsComboDataList;
import jp.co.takeda.rdm.dto.NC204DTO;
import jp.co.takeda.rdm.entity.SRdmDmcMstDeptEntity;
import jp.co.takeda.rdm.entity.SRdmJkrSosInsAbbrNameEntiry;
import jp.co.takeda.rdm.entity.join.SelectDeptListEntity;
import jp.co.takeda.rdm.util.AppMethods;
import jp.co.takeda.rdm.util.StringUtils;
import jp.co.takeda.rdm.entity.join.SelectDeptListEntityRDM;
import jp.co.takeda.rdm.entity.join.SelectHenkanListEntity;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;



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
    	SRdmJkrSosInsAbbrNameEntiry sRdmJkrSosAddrEntiry = new SRdmJkrSosInsAbbrNameEntiry();
        sRdmJkrSosAddrEntiry.setInsNo(indto.getParamInsNo());
        List<SRdmJkrSosInsAbbrNameEntiry> jkrSosAddrMap = dao.select(sRdmJkrSosAddrEntiry);
        indto.setInsAbbrName(jkrSosAddrMap.get(0).getInsAbbrName());
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
        // START UOC

        // ページ数(現在:１ページ目から)
        indto.setPageCntCur(1);

        //検索を行う
        outdto = search(indto);

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
        BaseDTO outdto = indto;
        insAbbrNameDrop(indto);
        // START UOC
        //検索条件_施設名（全角）



        //一覧検索件数取得の検索条件の設定
       // SelectDeptListEntity paramEntity = new SelectDeptListEntity();
      SelectDeptListEntityRDM paramEntity = new SelectDeptListEntityRDM();
      SelectDeptListEntityRDM paramEntity2 = new SelectDeptListEntityRDM(indto.getSearchInput());
      paramEntity.setScreenId("RDMND101");


      //入力_検索文字列  入力バーに入れられた値がnull、""でないかのチェック。
      if(indto.getSearchInput() == null) {
      	paramEntity.setSearchInput("");
      	paramEntity.setInSearchInput("");
      }else if(indto.getSearchInput().equals("")) {
        	paramEntity.setSearchInput("");
          	paramEntity.setInSearchInput("");
      }else {
    	  if (indto.getSearchInput().isEmpty()) {
          	indto.setSearchInput(null);
          }
          else {
          	 //漢字変換
          	SelectHenkanListEntity kanziHenkan = new SelectHenkanListEntity("漢字変換");
              kanziHenkan.setSearchHenkan(indto.getSearchInput());
              //漢字変換結果を格納
              List<SelectHenkanListEntity> selectKnazi = dao.select(kanziHenkan);
              for (SelectHenkanListEntity kanzi : selectKnazi) {
              	paramEntity.setSearchInput(kanzi.getSearchHenkan());
              }
          }
      //paramEntity.setSearchInput(indto.getSearchInput());
     // paramEntity.setInSearchInput(indto.getSearchInput());
      	paramEntity2.setSearchInput(indto.getSearchInput());
      	paramEntity2.setInSearchInput(indto.getSearchInput());
        SelectDeptListEntityRDM selectCntEntity2 = (SelectDeptListEntityRDM)dao.select(paramEntity2).get(0);
      	paramEntity.setSearchInput(selectCntEntity2.getSearchInput());
      	paramEntity.setInSearchInput(selectCntEntity2.getSearchInput());
      	//paramEntity=paramEntity2;
      }
        //入力_SELECT区分 (パラメータ1)
       // paramEntity.setInSelectKbn(0);
        //入力_施設固定コード (パラメータ2)
        //paramEntity.setInInsNo("004001005");//消化器内科344001289//高血圧004001005
        //paramEntity.setInsNo("004001005");//消化器内科344001289//高血圧004001005
        paramEntity.setInInsNo(indto.getParamInsNo());
        paramEntity.setInsNo(indto.getParamInsNo());
        //paramEntity.setInInsNo(indto.getParamInsNo());
        //入力_所属部科名カナ(パラメータ3)
        paramEntity.setInDeptKn("TEST");
        //paramEntity.setInDeptKn(StringUtils.setEmptyToNull(AppMethods.zKanaToHKana(indto.getKensakuKana())));
       //入力_所属部科名漢字 (パラメータ4)
        paramEntity.setInDeptKj("TEST");
       //paramEntity.setInDeptKj(StringUtils.setEmptyToNull(indto.getKensakuKanj()));
       //入力_全所属部科チェックボックス(パラメータ5)
        paramEntity.setAllCheck(indto.getAllCheck());
        if(paramEntity.getSearchInput() != null) {
         //画面初期表示時の所属部科一覧を取得する
      //  SelectDeptListEntity selectCntEntity = (SelectDeptListEntity)dao.select(paramEntity).get(0);
      //SelectDeptListEntityRDM selectCntEntity = (SelectDeptListEntityRDM)dao.select(paramEntity).get(0);
        //ページャー情報設定
        //indto.initPageInfo(indto.getPageCntCur(), selectCntEntity.getRecCnt(), 20);



        List<CatDeptsComboDataList> catDeptsComboDataList = new ArrayList<CatDeptsComboDataList>();

            //画面初期表示時の帳票一覧を取得する
            List<SelectDeptListEntityRDM> deptListEntity = dao.select(paramEntity);

            if(paramEntity.getScreenId() == "RDMND011") {
            	 for (SelectDeptListEntityRDM entiry : deptListEntity) {
                     CatDeptsComboDataList dataRecord = new CatDeptsComboDataList();

                     // 所属部科コード
                     dataRecord.setDeptCode(entiry.getDeptCode());

                     // 所属部科名漢字
                     dataRecord.setDeptKj(entiry.getDeptKj()); /*setDeptCode部分を修正している(DepjtK)*/

                     catDeptsComboDataList.add(dataRecord);
             }
            }else if(paramEntity.getScreenId() == "RDMND012") {
            	 for (SelectDeptListEntityRDM entiry : deptListEntity) {
                     CatDeptsComboDataList dataRecord = new CatDeptsComboDataList();

                     // 所属部科コード
                     dataRecord.setDeptCode(entiry.getDeptCode());

                     // 所属部科名漢字
                     dataRecord.setDeptKj(entiry.getDeptKj()); /*setDeptCode部分を修正している(DepjtK)*/

                     catDeptsComboDataList.add(dataRecord);
             }
            }else if(paramEntity.getScreenId() == "RDMND101") {
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
            }else if(paramEntity.getScreenId() == "RDMND102") {
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
            }

        indto.setParamInsNo(paramEntity.getInInsNo());
        //indto.setInsAbbrName("東北大学病院");
        //検索された帳票一覧をDTOに設定する
        indto.setCatDeptsComboDataList(catDeptsComboDataList);
        // END UOC
        }return outdto;
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

}
