/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.inject.Named;

import jp.co.takeda.rdm.common.BaseDTO;
import jp.co.takeda.rdm.common.BaseInfoHolder;
import jp.co.takeda.rdm.common.BaseService;
import jp.co.takeda.rdm.common.LoginInfo;
import jp.co.takeda.rdm.dto.CatSnseiComboDataList;
import jp.co.takeda.rdm.dto.CatTuuchiComboDataList;
import jp.co.takeda.rdm.dto.NF301DTO;
import jp.co.takeda.rdm.dto.CatTuuchiComboDataList;
import jp.co.takeda.rdm.dto.NM101DTO;
import jp.co.takeda.rdm.entity.MRdmComCalUsrEntity;
import jp.co.takeda.rdm.entity.SRdmReqListEntity;
import jp.co.takeda.rdm.entity.SRdmJkrSosAddrEntiry;
import jp.co.takeda.rdm.entity.SRdmJkrSosDocTypeEntiry;
import jp.co.takeda.rdm.entity.SRdmJkrSosFbPrcTypeEntiry;
import jp.co.takeda.rdm.entity.SRdmJkrSosFbReqFlgEntiry;
import jp.co.takeda.rdm.entity.SRdmJkrSosHoInsTypeEntiry;
import jp.co.takeda.rdm.entity.SRdmJkrSosInsClassEntiry;
import jp.co.takeda.rdm.entity.SRdmJkrSosInsSbtEntiry;
import jp.co.takeda.rdm.entity.SRdmJkrSosJobFormEntiry;
import jp.co.takeda.rdm.entity.SRdmJkrSosNtyPriEntiry;
import jp.co.takeda.rdm.entity.SRdmJkrSosNtyStsEntiry;
import jp.co.takeda.rdm.entity.SRdmJkrSosNtySubjectEntiry;
import jp.co.takeda.rdm.entity.SRdmJkrSosReqChlEntiry;
import jp.co.takeda.rdm.entity.SRdmJkrSosReqStsEntiry;
import jp.co.takeda.rdm.entity.SRdmJkrSosReqTypeEntiry;
import jp.co.takeda.rdm.entity.SRdmNtyListEntity;
import jp.co.takeda.rdm.entity.SRdmNtyUpdateEntity;
import jp.co.takeda.rdm.entity.SRdmNtyUpdateUpEntity;
import jp.co.takeda.rdm.entity.join.SelectCntSelectNtyListEntity;
import jp.co.takeda.rdm.entity.join.SelectHenkanListEntity;
import jp.co.takeda.rdm.entity.join.SelectParamNC011Entity;
import jp.co.takeda.rdm.entity.join.SelectParamNM101Entity;
import jp.co.takeda.rdm.entity.join.TRdmHcoReqEntity;
import jp.co.takeda.rdm.entity.join.TRdmReqKnrEntity;
import jp.co.takeda.rdm.util.DateUtils;
import jp.co.takeda.rdm.util.RdmConstantsData;
import jp.co.takeda.rdm.util.StringUtils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

/**
 * Serviceクラス（NM101)
 * @generated
 */
@Named
public class NM101Service extends BaseService {

    /**
     * ログインスタンス
     * @generated
     */
    private static Log log = LogFactory.getLog(NM101Service.class);



    //カレンダーの実装
    private void cal(NM101DTO indto)  throws ParseException  {
    	LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();
        loginInfo.getPreScreenId();

    	//本日日付_RDM用カレンダー(オンライン用)_生成用エンティティ
    	MRdmComCalUsrEntity paramComCalUsrToday = new MRdmComCalUsrEntity("1");

    	MRdmComCalUsrEntity paramComCalUsrKako = new MRdmComCalUsrEntity();
        //本日日付_RDM用カレンダー(オンライン用)の帳票一覧を取得する
        List<MRdmComCalUsrEntity> SelectComCalUsrToday = dao.select(paramComCalUsrToday);

        List<MRdmComCalUsrEntity> SelectComCalUsrKako = dao.select(paramComCalUsrKako);
        // SimpleDateFormatで日付フォーマット設定
     	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //本日日付データ_取り出す
//     	if("NM001".equals(loginInfo.getPreScreenId())) {
//     		//if(indto.getHisYmdhmsTo().length() == 8) {
////         	indto.setReqYmdhmsTo(indto.getHisYmdhmsTo().substring(0, 4)+ '-' + indto.getHisYmdhmsTo().substring(4, 6)+ '-' + indto.getHisYmdhmsTo().substring(6, 8));
////         	indto.setReqYmdhmsFrom(indto.getReqYmdhmsFrom().substring(0, 4)+ '-' + indto.getReqYmdhmsFrom().substring(4, 6)+ '-' + indto.getReqYmdhmsFrom().substring(6, 8));
//         	indto.setHisYmdhmsTo(indto.getInhisYmdhmsTo());
//         	indto.setHisYmdhmsFrom(indto.getInhisYmdhmsFrom());
//
//     		//}
//     	}

        for (MRdmComCalUsrEntity entity : SelectComCalUsrKako) {
            //検索結果_本日日付
            indto.setInhisYmdhmsFrom(sdf.format(entity.getCalDate()));
            indto.setKnYmdhmsFrom(sdf.format(entity.getCalDate()));
        }
        for (MRdmComCalUsrEntity entity : SelectComCalUsrToday) {
            //検索結果_過去日付
            indto.setInhisYmdhmsTo(sdf.format(entity.getCalDate()));
            indto.setKnYmdhmsTo(sdf.format(entity.getCalDate()));
        }
    }

    //ドロップダウンリスト-都道府県
    private void  addrDrop(NM101DTO indto) {
        // START UOC
        SRdmJkrSosAddrEntiry sRdmJkrSosAddrEntiry = new SRdmJkrSosAddrEntiry();
        List<SRdmJkrSosAddrEntiry> jkrSosAddrMap = dao.select(sRdmJkrSosAddrEntiry);
        LinkedHashMap<String, String> mapAddr = new LinkedHashMap<String, String>();
        mapAddr.put(null,"");
        for (SRdmJkrSosAddrEntiry outEntity : jkrSosAddrMap) {
        	mapAddr.put(outEntity.getAddrCodePref(),outEntity.getAddrNamePref());
        }
        mapAddr.put("99","その他");
        indto.setJkrSosAddrMap(mapAddr);
        // END UOC
    }

    //ドロップダウンリスト-通知件名
    private void  ntySubjectDrop(NM101DTO indto){
        // START UOC
    		SRdmJkrSosNtySubjectEntiry sRdmJkrSosNtySubjectEntiry = new SRdmJkrSosNtySubjectEntiry();
            List<SRdmJkrSosNtySubjectEntiry> jkrSosNtySubjectMap = dao.select(sRdmJkrSosNtySubjectEntiry);
            LinkedHashMap<String, String> mapReqType = new LinkedHashMap<String, String>();
            mapReqType.put("","--なし--");//nullの確認
            for (SRdmJkrSosNtySubjectEntiry outEntity : jkrSosNtySubjectMap) {
            	mapReqType.put(outEntity.getValue1(), outEntity.getValue1Kanj());
            }
            indto.setJkrSosNtySubject(mapReqType);
    }
    //ドロップダウンリスト-通知ステータス
    private void  ntyStsDrop(NM101DTO indto){
        // START UOC
    		SRdmJkrSosNtyStsEntiry sRdmJkrSosNtyStsEntiry = new SRdmJkrSosNtyStsEntiry();
            List<SRdmJkrSosNtyStsEntiry> jkrSosNtyStsMap = dao.select(sRdmJkrSosNtyStsEntiry);
            LinkedHashMap<String, String> mapReqType = new LinkedHashMap<String, String>();
            //mapReqType.put("","--なし--");//nullの確認
            for (SRdmJkrSosNtyStsEntiry outEntity : jkrSosNtyStsMap) {
            	mapReqType.put(outEntity.getValue1(), outEntity.getValue1Kanj());
            }
            indto.setJkrSosNtySts(mapReqType);
    }

    /**
     * イベント処理
     * @param indto ND001DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO sort(NM101DTO indto) throws ParseException{
        BaseDTO outdto = indto;
        // START UOC

        outdto = search(indto);

        // END UOC
        return outdto;
    }

    /**
     * イベント処理
     * @param indto RDMNM101DTO
     * @return 遷移先DTO
     * @customizable
     *  @throws ParseException
     */
    @Transactional
    public BaseDTO init(NM101DTO indto) throws ParseException{
    	LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();
    	//indto.setPreScreenId(loginInfo.getPreScreenId());
    	indto.setJgiNo(loginInfo.getJgiNo());
    	indto.setJgiName(loginInfo.getJgiName());
    	indto.setSosCd(loginInfo.getSosCd());
    	indto.setBrCode(loginInfo.getBrCode());
    	indto.setDistCode(loginInfo.getDistCode());
    	indto.setBumonRyakuName(loginInfo.getBumonRyakuName());
    	indto.setTrtCd(loginInfo.getTrtCd());
    	indto.setJokenSetCd(loginInfo.getJokenSetCd());



        BaseDTO outdto = indto;
        // START UOC
        addrDrop(indto);
        cal(indto);

        ntyStsDrop(indto);
        ntySubjectDrop(indto);

        // ページ数(現在:１ページ目から)
        indto.setPageCntCur(1);
        indto.setPageFlag("1");
        indto.setReqFlg("0");
        //検索を行う
        outdto = search(indto);

        // END UOC
        return outdto;

    }

	public BaseDTO search(NM101DTO indto) throws ParseException{
		BaseDTO outdto = indto;
		SRdmNtyUpdateEntity paramEntity = new SRdmNtyUpdateEntity();
		LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();


        boolean errFlg = false;
        String errMsg = "";
      //  List<NM101Entity> selectTestEntity = dao.select(paramEntity);
      //  indto.setTest(selectTestEntity.get(0).getTest());
		indto.setPageFlag("0");
        addrDrop(indto);


        ntyStsDrop(indto);
        ntySubjectDrop(indto);



        //paramEntity.setScreenId("RDMND101");
        List<CatTuuchiComboDataList> catTuuchiComboDataList = new ArrayList<CatTuuchiComboDataList>();

  		SelectParamNM101Entity selectParamReqNM101Entity = new SelectParamNM101Entity();
  		List<SelectParamNM101Entity> selectParamNM101List;
  		selectParamNM101List = dao.select(selectParamReqNM101Entity);

//        List<CatSnseiComboDataList> catSnseiComboDataList = new ArrayList<CatSnseiComboDataList>();
//
//  		SelectParamNC011Entity selectParamReqNC011Entity = new SelectParamNC011Entity();
//  		List<SelectParamNC011Entity> selectParamNC011List;
//  		selectParamNC011List = dao.select(selectParamReqNC011Entity);




  		//241002-000014 テスト用申請ID

          //SelectCntSelectNtyListEntity selectCntSelectNtyListEntity = new SelectCntSelectNtyListEntity();
          //List<SelectCntSelectNtyListEntity> selectParamSelectReqList;

          //アドミンflagの検索値のセット、setEmptyToNullで空文字をNullに置換している。
          paramEntity.setMrAdminFlg(StringUtils.setEmptyToNull(indto.getMrAdminFlg()));
          //selectCntSelectNtyListEntity.setMrAdminFlg(StringUtils.setEmptyToNull(indto.getMrAdminFlg()));


          //通知IDの検索値のセット、setEmptyToNullで空文字をNullに置換している。
          paramEntity.setNtyId(StringUtils.setEmptyToNull(indto.getNtyId()));
          //selectCntSelectNtyListEntity.setNtyId(StringUtils.setEmptyToNull(indto.getNtyId()));

          //通知分類の検索値のセット、setEmptyToNullで空文字をNullに置換している。
          paramEntity.setNtyBri(StringUtils.setEmptyToNull(indto.getNtyBri()));
          //selectCntSelectNtyListEntity.setNtyBri(StringUtils.setEmptyToNull(indto.getNtyBri()));

          //通知ステータスの検索値のセット、setEmptyToNullで空文字をNullに置換している。
          paramEntity.setNtySts(StringUtils.setEmptyToNull(indto.getNtySts()));
          //selectCntSelectNtyListEntity.setNtySts(StringUtils.setEmptyToNull(indto.getNtySts()));

          //通知優先度の検索値のセット、setEmptyToNullで空文字をNullに置換している。-MRのみ  //8830034
          paramEntity.setNtyPri(StringUtils.setEmptyToNull(indto.getNtyPri()));
          //selectCntSelectNtyListEntity.setNtyPri(StringUtils.setEmptyToNull(indto.getNtyPri()));
          //paramEntity.setReqJgiNo("8830034");//test用

          //最終更新日時の検索値のセット、setEmptyToNullで空文字をNullに置換している。
          paramEntity.setSsUpdYmdhms(StringUtils.setEmptyToNull(indto.getSsUpdYmdhms()));
         // selectCntSelectNtyListEntity.setSsUpdYmdhms(StringUtils.setEmptyToNull(indto.getSsUpdYmdhms()));

          //通知件名の検索値のセット、setEmptyToNullで空文字をNullに置換している。
          paramEntity.setNtySubject(StringUtils.setEmptyToNull(indto.getNtySubject()));
        //  selectCntSelectNtyListEntity.setNtySubject(StringUtils.setEmptyToNull(indto.getNtySubject()));

          //通知内容の検索値のセット、setEmptyToNullで空文字をNullに置換している。
          paramEntity.setNtyData(StringUtils.setEmptyToNull(indto.getNtyData()));
        //  selectCntSelectNtyListEntity.setNtyData(StringUtils.setEmptyToNull(indto.getNtyData()));

          //通知メモの検索値のセット、setEmptyToNullで空文字をNullに置換している。
          paramEntity.setNtyMemo(StringUtils.setEmptyToNull(indto.getNtyMemo()));
       //   selectCntSelectNtyListEntity.setNtyMemo(StringUtils.setEmptyToNull(indto.getNtyMemo()));

          if(paramEntity.isDataDupCheck() == true ||  paramEntity.isUltRnkCheck()  == true ||  paramEntity.isFbResCheck()  == true || paramEntity.isConsCheck() == true || paramEntity.isOthersCheck() == true|| paramEntity.isOnlyCheck() == true) {
        	  paramEntity.setNtyBri("001");
    //    	  selectCntSelectNtyListEntity.setNtyBri("001");
          }

          if(paramEntity.isUnconCheck() == true || paramEntity.isUbderCheck() == true || paramEntity.isResolvCheck() == true) {
        	  paramEntity.setNtySts("1");
 //       	  selectCntSelectNtyListEntity.setNtySts("1");
          }



          //申請日前部分の検索値のセット、setEmptyToNullで空文字をNullに置換している。
          paramEntity.setHisYmdhmsFrom(StringUtils.setEmptyToNull(indto.getHisYmdhmsFrom()));
          //selectCntSelectNtyListEntity.setHisYmdhmsFrom(StringUtils.setEmptyToNull(indto.getHisYmdhmsFrom()));

//          //申請日前部分の検索値のセット、setEmptyToNullで空文字をNullに置換している。
//          paramEntity.setHisYmdhmsTo(StringUtils.setEmptyToNull(indto.getHisYmdhmsTo()));
//          selectCntSelectNtyListEntity.setHisYmdhmsTo(StringUtils.setEmptyToNull(indto.getHisYmdhmsTo()));


          //申請日前部分の検索値のセット、setEmptyToNullで空文字をNullに置換している。inOffset
          paramEntity.setInOffset(indto.getInOffset());
         // selectCntSelectNtyListEntity.setInOffset(indto.getInOffset());

          //申請日前部分の検索値のセット、setEmptyToNullで空文字をNullに置換している。inLimit
          paramEntity.setInLimit(indto.getInLimit());
      //    selectCntSelectNtyListEntity.setInLimit(indto.getInLimit());

          //ソートIDのセット
          paramEntity.setInSortId(indto.getSortCondition());


          String workSortCondition = indto.getSortCondition();




          //入力_検索文字列  施設名がnullでないかのチェック。
         // selectParamSelectReqList =dao.select(paramEntity);

         // selectParamSelectReqList  = dao.select(selectCntSelectNtyListEntity);
          //1000件以上の場合のエラー
    	   // if (selectParamSelectReqList.get(0).getCntReq() > selectParamNM101List.get(0).getValue()) {//deptListEntity.size()
    	    //	indto.setBoolKnb("2");
        		//return outdto;
    	//    }

          //indto.initPageInfo(indto.getPageCntCur(), selectParamSelectReqList.get(0).getCntReq(), selectParamNM101List.get(1).getValue());
          //paramEntity.setInOffset(indto.getLineCntStart() - 1);
          //paramEntity.setInLimit(selectParamNM101List.get(1).getValue());
              //画面初期表示時の帳票一覧を取得する
              List<SRdmNtyUpdateEntity> deptListEntity = dao.select(paramEntity);



             // for(int i = 0;i < 11; i++) {
              	 for (SRdmNtyUpdateEntity entity : deptListEntity) {
              		CatTuuchiComboDataList dataRecord = new CatTuuchiComboDataList();

              		// 通知ID
                	if(entity.getNtyId() != null) {
                	dataRecord.setNtyId(entity.getNtyId());
                	}else {
                	dataRecord.setNtyId(" ");
                	}

                    // 発生日時
                	if(entity.getHisYmdhmsTo() != null) {
                        if(entity.getHisYmdhmsTo().length() == 8) {
                        	dataRecord.setHisYmdhmsTo(entity.getHisYmdhmsTo().substring(0, 4)+ '/' + entity.getHisYmdhmsTo().substring(4, 6)+ '/' + entity.getHisYmdhmsTo().substring(6, 8));
                        }else if(entity.getHisYmdhmsTo().length() == 12) {
                        	dataRecord.setHisYmdhmsTo(entity.getHisYmdhmsTo().substring(0, 4)+ '/' + entity.getHisYmdhmsTo().substring(4, 6)+ '/' + entity.getHisYmdhmsTo().substring(6, 8)+ ' ' + entity.getHisYmdhmsTo().substring(8, 10)+ ':' + entity.getHisYmdhmsTo().substring(10, 12));
                        }else if(entity.getHisYmdhmsTo().length() == 14) {
                        	dataRecord.setHisYmdhmsTo(entity.getHisYmdhmsTo().substring(0, 4)+ '/' + entity.getHisYmdhmsTo().substring(4, 6)+ '/' + entity.getHisYmdhmsTo().substring(6, 8)+ ' ' + entity.getHisYmdhmsTo().substring(8, 10)+ ':' + entity.getHisYmdhmsTo().substring(10, 12)+ ':' + entity.getHisYmdhmsTo().substring(12, 14));
                        	indto.setHisYmdhmsTo(entity.getHisYmdhmsTo().substring(0, 4)+ '/' + entity.getHisYmdhmsTo().substring(4, 6)+ '/' + entity.getHisYmdhmsTo().substring(6, 8)+ ' ' + entity.getHisYmdhmsTo().substring(8, 10)+ ':' + entity.getHisYmdhmsTo().substring(10, 12)+ ':' + entity.getHisYmdhmsTo().substring(12, 14));
                        }
                	//dataRecord.setReqYmdhmsTo(entity.getHisYmdhmsTo());
                	}else {
                		dataRecord.setHisYmdhmsTo(" ");
                	}

              		// 通知分類
                	if(entity.getNtyBri() != null) {
                	dataRecord.setNtyBri(entity.getNtyBri());
                	indto.setNtyBri(entity.getNtyBri());
                	}else {
                	dataRecord.setNtyBri(" ");
                	}

              		// 通知件名
                	if(entity.getNtySubject() != null) {
                	dataRecord.setNtySubject(entity.getNtySubject());
                	indto.setNtySubject(entity.getNtySubject());
                	}else {
                	dataRecord.setNtySubject(" ");
                	}

              		// 通知内容

              		// 通知内容2
                	if(entity.getNtyData2() != null) {
                	indto.setNtyData2(entity.getNtyData2());
                	//dataRecord.setNtyData(entity.getNtyData().replace("\\n", "<br>"));
                	}else {
                		indto.setNtyData2(" ");
                	}
              		// 通知内容3
                	if(entity.getNtyData3() != null) {
                	indto.setNtyData3(entity.getNtyData3());
                	//dataRecord.setNtyData(entity.getNtyData().replace("\\n", "<br>"));
                	}else {
                		indto.setNtyData3(" ");
                	}
              		// 通知内容4
                	if(entity.getNtyData4() != null) {
                	indto.setNtyData4(entity.getNtyData4());
                	//dataRecord.setNtyData(entity.getNtyData().replace("\\n", "<br>"));
                	}else {
                		indto.setNtyData4(" ");
                	}
              		// 通知内容5
                	if(entity.getNtyData5() != null) {
                	indto.setNtyData5(entity.getNtyData5());
                	//dataRecord.setNtyData(entity.getNtyData().replace("\\n", "<br>"));
                	}else {
                		indto.setNtyData5(" ");
                	}
              		// 通知内容
                	if(entity.getNtyData() != null) {
                	dataRecord.setNtyData(entity.getNtyData());
                	indto.setNtyData(entity.getNtyData() + indto.getNtyData2() + indto.getNtyData3() + indto.getNtyData4() + indto.getNtyData5());
                	//dataRecord.setNtyData(entity.getNtyData().replace("\\n", "<br>"));
                	}else {
                		indto.setNtyData(" ");
                	}

              		// メモ
                	if(entity.getNtyMemo() != null) {
                	dataRecord.setNtyMemo(entity.getNtyMemo());
                	indto.setNtyMemo(entity.getNtyMemo());
                	}else {
                		indto.setNtyMemo(" ");
                	}

              		// 通知ステータス
                	if(entity.getNtySts() != null) {
                		if(entity.getNtySts().equals("0") || entity.getNtySts().equals("未確認")) {
		                	dataRecord.setNtySts("0");
		                	indto.setNtySts("0");
	                	}else if(entity.getNtySts().equals("1") || entity.getNtySts().equals("確認中")) {
	                    	dataRecord.setNtySts("1");
	                    	indto.setNtySts("1");
                    	}else if(entity.getNtySts().equals("2") || entity.getNtySts().equals("解消済")) {
                        	dataRecord.setNtySts("2");
                        	indto.setNtySts("2");
                        }else{
                		indto.setNtySts(" ");
                        }
                	}


              		// 通知優先度
                	if(entity.getNtyPri() != null) {
                	dataRecord.setNtyPri(entity.getNtyPri());
                	}else {
                	dataRecord.setNtyPri(" ");
                	}

                    // 最終更新日時
                   	if(entity.getSsUpdYmdhms() != null) {
                        if(entity.getSsUpdYmdhms().length() == 8) {
                        	dataRecord.setSsUpdYmdhms(entity.getSsUpdYmdhms().substring(0, 4)+ '/' + entity.getSsUpdYmdhms().substring(4, 6)+ '/' + entity.getSsUpdYmdhms().substring(6, 8));
                        }else if(entity.getSsUpdYmdhms().length() == 12) {
                        	dataRecord.setSsUpdYmdhms(entity.getSsUpdYmdhms().substring(0, 4)+ '/' + entity.getSsUpdYmdhms().substring(4, 6)+ '/' + entity.getSsUpdYmdhms().substring(6, 8)+ ' ' + entity.getSsUpdYmdhms().substring(8, 10)+ ':' + entity.getSsUpdYmdhms().substring(10, 12));
                        }else if(entity.getSsUpdYmdhms().length() == 14) {
                        	dataRecord.setSsUpdYmdhms(entity.getSsUpdYmdhms().substring(0, 4)+ '/' + entity.getSsUpdYmdhms().substring(4, 6)+ '/' + entity.getSsUpdYmdhms().substring(6, 8)+ ' ' + entity.getSsUpdYmdhms().substring(8, 10)+ ':' + entity.getSsUpdYmdhms().substring(10, 12)+ ':' + entity.getSsUpdYmdhms().substring(12, 14));
                        	indto.setSsUpdYmdhms(entity.getSsUpdYmdhms().substring(0, 4)+ '/' + entity.getSsUpdYmdhms().substring(4, 6)+ '/' + entity.getSsUpdYmdhms().substring(6, 8)+ ' ' + entity.getSsUpdYmdhms().substring(8, 10)+ ':' + entity.getSsUpdYmdhms().substring(10, 12)+ ':' + entity.getSsUpdYmdhms().substring(12, 14));
                        }
                    	//dataRecord.setAPR_YMDHMS(entity.getAPR_YMDHMS());
                    	}else {
                    		dataRecord.setSsUpdYmdhms(" ");
                    	}
                       //dataRecord.setAPR_YMDHMS(entity.getAPR_YMDHMS());

                       //dataRecord.setInsFormalName(entity.getInsFormalName());
                    // 申請者名
                   	if(entity.getJgiName() != null) {
                    	dataRecord.setReqJgiName(entity.getJgiName());
                    	//indto.setReqJgiName(entity.getReqJgiName());
                    	}else {
                    		dataRecord.setReqJgiName(" ");
                    	}
                   	catTuuchiComboDataList .add(dataRecord);
               }
            //  }
              Boolean check = false;
          //indto.setParamInsNo(paramEntity.getInInsNo());
          //indto.setInsAbbrName("東北大学病院");
          //検索された帳票一覧をDTOに設定する
              if(catTuuchiComboDataList.size()>1000) {
            	  check = true;
              }
              if(check == true) {
            	  System.out.print("1000件エラー");
              }

        		paramEntity.setReqId(StringUtils.setEmptyToNull(indto.getReqId()));

          		if(paramEntity.getReqId() != null) {

        			SRdmNtyUpdateUpEntity sRdmNtyUpdateUpEntity = new SRdmNtyUpdateUpEntity("selectByPK");
        			sRdmNtyUpdateUpEntity.setReqId(indto.getReqId());

        			List<SRdmNtyUpdateUpEntity> sRdmNtyUpdateCnrEntity = dao.select(sRdmNtyUpdateUpEntity);
        			if(!CollectionUtils.isEmpty(sRdmNtyUpdateCnrEntity)) {
        				//indto.setForward("NC011Init");
        	        	indto.setReqId(paramEntity.getReqId());
        	        	if(indto.getReqFlg().equals("2")) {
        	        		indto.setReqFlg("1");
	        	        	outdto = indto;
	        				return outdto;
        			}
        			}
        			if(CollectionUtils.isEmpty(sRdmNtyUpdateCnrEntity)) {
        			errMsg += loginInfo.getMsgData(RdmConstantsData.I001).replace("項目名", "申請IDなし") + "\n";
        			errFlg = true;
        	        // エラー時処理
        	        if(errFlg) {
        	        	indto.setMsgStr(errMsg);
        	        	return outdto;
        	        }
        		}
        			return outdto;

          		}


          indto.setCatTuuchiComboDataList(catTuuchiComboDataList);

          indto.setSortCondition(workSortCondition);

      //     END UOC
          return outdto;
          }

    /**
     * イベント処理
     * @param indto ND001DTO
     * @return 遷移先DTO
     * @throws ParseException
     * @customizable
     */
    @Transactional
    public BaseDTO page(NM101DTO indto) throws ParseException {
        BaseDTO outdto = indto;
        // START UOC

        outdto = search(indto);

        // END UOC
        return outdto;
    }

    /**
     * イベント処理
     * @param indto NF301DTO
     * @return 遷移先DTO
     * @throws ParseException
     * @customizable
     */
    @SuppressWarnings("unlikely-arg-type")
	@Transactional
    public BaseDTO register(NM101DTO indto) throws ParseException {
        BaseDTO outdto = indto;
        // START UOC
        LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();
        indto.setJgiNo(loginInfo.getJgiNo());
        //outdto.setForward("NF301");
        ntyStsDrop(indto);
        ntySubjectDrop(indto);


        // 現在日付を取得
        Date systemDate = DateUtils.getNowDate();
        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");
        String sysDate = fmtDate.format(systemDate);
        SimpleDateFormat fmtDateTime = new SimpleDateFormat("yyyyMMddHHmmss");
        String sysDateTime = fmtDateTime.format(systemDate);

        boolean errFlg = false;
        String errMsg = "";

        //indto.getNtyMemo() != null &&
        if(indto.getNtyMemo().length() > 250) {
        	// 最大文字数を超えています。（メモ）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "メモ") + "\n";
			errFlg = true;
        }

        // 最終更新日時が、画面OPEN時とボタン押下時で異なっていた場合
		if(indto.getSsUpdYmdhms() != null && !indto.getSsUpdYmdhms().equals("")) {
			SRdmNtyUpdateUpEntity sRdmNtyUpdateUpEntity = new SRdmNtyUpdateUpEntity("selectNM101DateChkData");
			sRdmNtyUpdateUpEntity.setNtyId(indto.getNtyId());

			List<SRdmNtyUpdateUpEntity> sRdmNtyUpdateCnrEntity = dao.select(sRdmNtyUpdateUpEntity);

			if(sRdmNtyUpdateCnrEntity.size() > 0) {
        		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        		Date updDate = null;
                try {
					updDate = sdFormat.parse(indto.getUpdShaYmd());
				} catch (ParseException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
					}
        		if(!sRdmNtyUpdateCnrEntity.get(0).getUpdShaYmd().equals(updDate)) {
        			// 既に他のユーザーによってデータが処理されています。
        			errMsg += loginInfo.getMsgData(RdmConstantsData.E003) + "\n";
    	        	errFlg = true;
        		}
        	}
		}

        // エラー時処理
        if(errFlg) {
        	indto.setMsgStr(errMsg);
        	outdto = search(indto);
        	return outdto;
        }



			// 申請
        SRdmNtyUpdateUpEntity sRdmNtyUpdateUpEntity = new SRdmNtyUpdateUpEntity();

        sRdmNtyUpdateUpEntity.setNtyId(indto.getNtyId());//NTY2568709
      //通知ステータスの検索値のセット、setEmptyToNullで空文字をNullに置換している。
        sRdmNtyUpdateUpEntity.setNtySts(StringUtils.setEmptyToNull(indto.getNtySts()));
        sRdmNtyUpdateUpEntity.setNtyMemo(StringUtils.setEmptyToNull(indto.getNtyMemo()));
        //sRdmNtyUpdateUpEntity.setNtySts(indto.getNtySts());
    	sRdmNtyUpdateUpEntity.setSsUpdYmdhms(sysDateTime);
    	sRdmNtyUpdateUpEntity.setSsUpdJgiNo(indto.getJgiNo());


    	dao.update(sRdmNtyUpdateUpEntity);
    	indto.setReqFlg("0");
    	indto.setMsgStr("保存が完了しました。");
    	outdto = search(indto);

    	//outdto.setForward("NC101");

		// END UOC
		return outdto;
    }

}
