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
import jp.co.takeda.rdm.dto.CatTuuchiComboDataList;
import jp.co.takeda.rdm.dto.NM011DTO;
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
import jp.co.takeda.rdm.entity.SRdmJkrSosNtySubjectEntiry;
import jp.co.takeda.rdm.entity.SRdmJkrSosReqChlEntiry;
import jp.co.takeda.rdm.entity.SRdmJkrSosReqStsEntiry;
import jp.co.takeda.rdm.entity.SRdmJkrSosReqTypeEntiry;
import jp.co.takeda.rdm.entity.SRdmNtyListEntity;
import jp.co.takeda.rdm.entity.join.SelectCntSelectNtyListEntity;
import jp.co.takeda.rdm.entity.join.SelectHenkanListEntity;
import jp.co.takeda.rdm.entity.join.SelectParamNC011Entity;
import jp.co.takeda.rdm.entity.join.SelectParamNM011Entity;
import jp.co.takeda.rdm.util.RdmConstantsData;
import jp.co.takeda.rdm.util.StringUtils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 * Serviceクラス（NM011)
 * @generated
 */
@Named
public class NM011Service extends BaseService {

    /**
     * ログインスタンス
     * @generated
     */
    private static Log log = LogFactory.getLog(NM011Service.class);



    //カレンダーの実装
    private void cal(NM011DTO indto)  throws ParseException  {
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
    private void  addrDrop(NM011DTO indto) {
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
    //ドロップダウンリスト-申請区分
    private void  reqTypeDrop(NM011DTO indto) {
        // START UOC
    	String check ="全て";
    	int idFlg;
    	if(check.equals("全て")) {//種別：全て選択時
    		SRdmJkrSosReqTypeEntiry sRdmJkrSosReqTypeEntiry = new SRdmJkrSosReqTypeEntiry();
            List<SRdmJkrSosReqTypeEntiry> jkrSosReqTypeMap = dao.select(sRdmJkrSosReqTypeEntiry);
            LinkedHashMap<String, String> mapReqType = new LinkedHashMap<String, String>();
            mapReqType.put(null,"全て");
            for (SRdmJkrSosReqTypeEntiry outEntity : jkrSosReqTypeMap) {
            	mapReqType.put(outEntity.getValue1(), outEntity.getValue1Kanj());
            }
            indto.setJkrSosReqTypeMap(mapReqType);
    	}
    		if(check.equals("施設")) {//種別：施設選択時
    			idFlg =0;
    			SRdmJkrSosReqTypeEntiry sRdmJkrSosReqTypeEntiry = new SRdmJkrSosReqTypeEntiry(idFlg);
    	        List<SRdmJkrSosReqTypeEntiry> jkrSosReqTypeMap = dao.select(sRdmJkrSosReqTypeEntiry);
    	        LinkedHashMap<String, String> mapReqType = new LinkedHashMap<String, String>();
    	        mapReqType.put(null,"全て");
    	        for (SRdmJkrSosReqTypeEntiry outEntity : jkrSosReqTypeMap) {
    	        	mapReqType.put(outEntity.getValue1(), outEntity.getValue1Kanj());
    	        }
    	        indto.setJkrSosReqTypeMap(mapReqType);
    		}else if(check.equals("医師")) {//種別：医師選択時
    			idFlg =1;
    			SRdmJkrSosReqTypeEntiry sRdmJkrSosReqTypeEntiry = new SRdmJkrSosReqTypeEntiry(idFlg);
    	        List<SRdmJkrSosReqTypeEntiry> jkrSosReqTypeMap = dao.select(sRdmJkrSosReqTypeEntiry);
    	        LinkedHashMap<String, String> mapReqType = new LinkedHashMap<String, String>();
    	        mapReqType.put(null,"全て");
    	        for (SRdmJkrSosReqTypeEntiry outEntity : jkrSosReqTypeMap) {
    	        	mapReqType.put(outEntity.getValue1(), outEntity.getValue1Kanj());
    	        }
    	        indto.setJkrSosReqTypeMap(mapReqType);
    		}
        // END UOC
    }
    //ドロップダウンリスト-申請ステータス
    private void  reqStsDrop(NM011DTO indto){
        // START UOC
    		SRdmJkrSosReqStsEntiry sRdmJkrSosReqStsEntiry = new SRdmJkrSosReqStsEntiry();
            List<SRdmJkrSosReqStsEntiry> jkrSosReqStsMap = dao.select(sRdmJkrSosReqStsEntiry);
            LinkedHashMap<String, String> mapReqType = new LinkedHashMap<String, String>();
            mapReqType.put(null,"全て");
            for (SRdmJkrSosReqStsEntiry outEntity : jkrSosReqStsMap) {
            	mapReqType.put(outEntity.getValue1(), outEntity.getValue1Kanj());
            }
            indto.setJkrSosReqStsMap(mapReqType);
    }
    //ドロップダウンリスト-施設分類
    private void  insClassDrop(NM011DTO indto){
        // START UOC
    		SRdmJkrSosInsClassEntiry sRdmJkrSosInsClassEntiry = new SRdmJkrSosInsClassEntiry();
            List<SRdmJkrSosInsClassEntiry> jkrSosInsClassMap = dao.select(sRdmJkrSosInsClassEntiry);
            LinkedHashMap<String, String> mapReqType = new LinkedHashMap<String, String>();
            mapReqType.put(null," ");
            for (SRdmJkrSosInsClassEntiry outEntity : jkrSosInsClassMap) {
            	mapReqType.put(outEntity.getValue1(), outEntity.getValue1Kanj());
            }
            indto.setJkrSosInsClassMap(mapReqType);
    }
    //ドロップダウンリスト-施設種別
    private void  insSbtDrop(NM011DTO indto){
        // START UOC
    		SRdmJkrSosInsSbtEntiry sRdmJkrSosInsSbtEntiry = new SRdmJkrSosInsSbtEntiry();
            List<SRdmJkrSosInsSbtEntiry> jkrSosInsSbtMap = dao.select(sRdmJkrSosInsSbtEntiry);
            LinkedHashMap<String, String> mapReqType = new LinkedHashMap<String, String>();
            mapReqType.put(null," ");
            for (SRdmJkrSosInsSbtEntiry outEntity : jkrSosInsSbtMap) {
            	mapReqType.put(outEntity.getValue1(), outEntity.getValue1Kanj());
            }
            indto.setJkrSosInsSbtMap(mapReqType);
    }
    //ドロップダウンリスト-医師種別
    private void  docTypeDrop(NM011DTO indto){
        // START UOC
    		SRdmJkrSosDocTypeEntiry sRdmJkrSosDocTypeEntiry = new SRdmJkrSosDocTypeEntiry();
            List<SRdmJkrSosDocTypeEntiry> jkrSosDocTypeMap = dao.select(sRdmJkrSosDocTypeEntiry);
            LinkedHashMap<String, String> mapReqType = new LinkedHashMap<String, String>();
            mapReqType.put(null," ");
            for (SRdmJkrSosDocTypeEntiry outEntity : jkrSosDocTypeMap) {
            	mapReqType.put(outEntity.getValue1(), outEntity.getValue1Kanj());
            }
            indto.setJkrSosDocTypeMap(mapReqType);
    }

    //ドロップダウンリスト-勤務形態
    private void  jobFormDrop(NM011DTO indto){
        // START UOC
    		SRdmJkrSosJobFormEntiry sRdmJkrSosJobFormEntiry = new SRdmJkrSosJobFormEntiry();
            List<SRdmJkrSosJobFormEntiry> jkrSosJobFormMap = dao.select(sRdmJkrSosJobFormEntiry);
            LinkedHashMap<String, String> mapReqType = new LinkedHashMap<String, String>();
            mapReqType.put(null," ");
            for (SRdmJkrSosJobFormEntiry outEntity : jkrSosJobFormMap) {
            	mapReqType.put(outEntity.getValue1(), outEntity.getValue1Kanj());
            }
            indto.setJkrSosJobFormMap(mapReqType);
    }

    //ドロップダウンリスト-対象区分
    private void  hoInsTypeDrop(NM011DTO indto){
        // START UOC
    		SRdmJkrSosHoInsTypeEntiry sRdmJkrSosHoInsTypeEntiry = new SRdmJkrSosHoInsTypeEntiry();
            List<SRdmJkrSosHoInsTypeEntiry> jkrSosHoInsTypeMap = dao.select(sRdmJkrSosHoInsTypeEntiry);
            LinkedHashMap<String, String> mapReqType = new LinkedHashMap<String, String>();
            mapReqType.put(null," ");
            for (SRdmJkrSosHoInsTypeEntiry outEntity : jkrSosHoInsTypeMap) {
            	mapReqType.put(outEntity.getValue1(), outEntity.getValue1Kanj());
            }
            indto.setJkrSosHoInsTypeMap(mapReqType);
    }

    //ドロップダウンリスト-通知件名
    private void  ntySubjectDrop(NM011DTO indto){
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
    //ドロップダウンリスト-通知件名
    private void  ntyPriDrop(NM011DTO indto){
        // START UOC
    		SRdmJkrSosNtyPriEntiry sRdmJkrSosNtypriEntiry = new SRdmJkrSosNtyPriEntiry();
            List<SRdmJkrSosNtyPriEntiry> jkrSosNtypriMap = dao.select(sRdmJkrSosNtypriEntiry);
            LinkedHashMap<String, String> mapReqType = new LinkedHashMap<String, String>();
            mapReqType.put("","--なし--");//nullの確認
            for (SRdmJkrSosNtyPriEntiry outEntity : jkrSosNtypriMap) {
            	mapReqType.put(outEntity.getValue1(), outEntity.getValue1Kanj());
            }
            indto.setJkrSosNtyPri(mapReqType);
    }



    //ドロップダウンリスト-種別
    private void  sbtDrop(NM011DTO indto) {
        // START UOC
        LinkedHashMap<String, String> mapAddr = new LinkedHashMap<String, String>();
        mapAddr.put(null," ");
        mapAddr.put("0","施設");
        mapAddr.put("1","医師");
        indto.setJkrSosSbtMap(mapAddr);
        // END UOC
    }
    //FB申請要否
    private void  FbReqFlg(NM011DTO indto){
        // START UOC
    		SRdmJkrSosFbReqFlgEntiry sRdmJkrSosFbReqFlgEntiry = new SRdmJkrSosFbReqFlgEntiry();
            List<SRdmJkrSosFbReqFlgEntiry> jkrSosFbReqFlgMap = dao.select(sRdmJkrSosFbReqFlgEntiry);
            LinkedHashMap<String, String> mapReqType = new LinkedHashMap<String, String>();
            for (SRdmJkrSosFbReqFlgEntiry outEntity : jkrSosFbReqFlgMap) {
            	mapReqType.put(outEntity.getValue1(), outEntity.getValue1Kanj());
            }
            indto.setJkrSosFbReqFlgMap(mapReqType);
    }
    //FB申請要否
    private void  FbPrcType(NM011DTO indto){
        // START UOC
    		SRdmJkrSosFbPrcTypeEntiry sRdmJkrSosFbPrcTypeEntiry = new SRdmJkrSosFbPrcTypeEntiry();
            List<SRdmJkrSosFbPrcTypeEntiry> jkrSosFbPrcTypeMap = dao.select(sRdmJkrSosFbPrcTypeEntiry);
            LinkedHashMap<String, String> mapReqType = new LinkedHashMap<String, String>();
            for (SRdmJkrSosFbPrcTypeEntiry outEntity : jkrSosFbPrcTypeMap) {
            	mapReqType.put(outEntity.getValue1(), outEntity.getValue1Kanj());
            }
            indto.setJkrSosFbPrcTypeMap(mapReqType);
    }
    /**
     * イベント処理
     * @param indto ND001DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO sort(NM011DTO indto) throws ParseException{
        BaseDTO outdto = indto;
        // START UOC

        outdto = search(indto);

        // END UOC
        return outdto;
    }

    /**
     * イベント処理
     * @param indto RDMNM011DTO
     * @return 遷移先DTO
     * @customizable
     *  @throws ParseException
     */
    @Transactional
    public BaseDTO init(NM011DTO indto) throws ParseException{
    	LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();
    	indto.setPreScreenId(loginInfo.getPreScreenId());

        BaseDTO outdto = indto;
        // START UOC
        addrDrop(indto);
        cal(indto);
        sbtDrop(indto);

        reqTypeDrop(indto);
        reqStsDrop(indto);
        insSbtDrop(indto);
        insClassDrop(indto);
        hoInsTypeDrop(indto);
        docTypeDrop(indto);
        jobFormDrop(indto);
        ntyPriDrop(indto);
        ntySubjectDrop(indto);
        FbReqFlg(indto);
        FbPrcType(indto);
        // ページ数(現在:１ページ目から)
        indto.setPageCntCur(1);
        indto.setPageFlag("1");

        // 初期表示は発生日時降順
        indto.setSortCondition("3");
        if("NM001".equals(indto.getPreScreenId())) {
        	outdto = search(indto);
        }

        // END UOC
        return outdto;

    }

	public BaseDTO search(NM011DTO indto) throws ParseException{
		BaseDTO outdto = indto;
		SRdmNtyListEntity paramEntity = new SRdmNtyListEntity();
      //  List<NM011Entity> selectTestEntity = dao.select(paramEntity);
      //  indto.setTest(selectTestEntity.get(0).getTest());
    	LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();
    	indto.setPreScreenId(loginInfo.getPreScreenId());
		indto.setPageFlag("0");
        addrDrop(indto);

        sbtDrop(indto);
        ntyPriDrop(indto);
        ntySubjectDrop(indto);

        reqTypeDrop(indto);
        reqStsDrop(indto);
        insSbtDrop(indto);
        insClassDrop(indto);
        hoInsTypeDrop(indto);
        docTypeDrop(indto);
        jobFormDrop(indto);

        FbReqFlg(indto);
        FbPrcType(indto);
        //paramEntity.setScreenId("RDMND101");
        List<CatTuuchiComboDataList> catTuuchiComboDataList = new ArrayList<CatTuuchiComboDataList>();

  		SelectParamNM011Entity selectParamReqNM011Entity = new SelectParamNM011Entity();
  		List<SelectParamNM011Entity> selectParamNM011List;
  		selectParamNM011List = dao.select(selectParamReqNM011Entity);

//        List<CatSnseiComboDataList> catSnseiComboDataList = new ArrayList<CatSnseiComboDataList>();
//
//  		SelectParamNC011Entity selectParamReqNC011Entity = new SelectParamNC011Entity();
//  		List<SelectParamNC011Entity> selectParamNC011List;
//  		selectParamNC011List = dao.select(selectParamReqNC011Entity);




  		//241002-000014 テスト用申請ID

          SelectCntSelectNtyListEntity selectCntSelectNtyListEntity = new SelectCntSelectNtyListEntity();
          List<SelectCntSelectNtyListEntity> selectParamSelectReqList;

          //アドミンflagの検索値のセット、setEmptyToNullで空文字をNullに置換している。
          paramEntity.setMrAdminFlg(StringUtils.setEmptyToNull(indto.getMrAdminFlg()));
          selectCntSelectNtyListEntity.setMrAdminFlg(StringUtils.setEmptyToNull(indto.getMrAdminFlg()));


          //通知IDの検索値のセット、setEmptyToNullで空文字をNullに置換している。
          paramEntity.setNtyId(StringUtils.setEmptyToNull(indto.getNtyId()));
          selectCntSelectNtyListEntity.setNtyId(StringUtils.setEmptyToNull(indto.getNtyId()));

          //通知分類の検索値のセット、setEmptyToNullで空文字をNullに置換している。
          paramEntity.setNtyBri(StringUtils.setEmptyToNull(indto.getNtyBri()));
          selectCntSelectNtyListEntity.setNtyBri(StringUtils.setEmptyToNull(indto.getNtyBri()));

          //通知ステータスの検索値のセット、setEmptyToNullで空文字をNullに置換している。
          paramEntity.setNtySts(StringUtils.setEmptyToNull(indto.getNtySts()));
          selectCntSelectNtyListEntity.setNtySts(StringUtils.setEmptyToNull(indto.getNtySts()));

          //通知優先度の検索値のセット、setEmptyToNullで空文字をNullに置換している。-MRのみ  //8830034
          paramEntity.setNtyPri(StringUtils.setEmptyToNull(indto.getNtyPri()));
          selectCntSelectNtyListEntity.setNtyPri(StringUtils.setEmptyToNull(indto.getNtyPri()));
          //paramEntity.setReqJgiNo("8830034");//test用

          //最終更新日時の検索値のセット、setEmptyToNullで空文字をNullに置換している。
          paramEntity.setSsUpdYmdhms(StringUtils.setEmptyToNull(indto.getSsUpdYmdhms()));
          selectCntSelectNtyListEntity.setSsUpdYmdhms(StringUtils.setEmptyToNull(indto.getSsUpdYmdhms()));

          //通知件名の検索値のセット、setEmptyToNullで空文字をNullに置換している。
          paramEntity.setNtySubject(StringUtils.setEmptyToNull(indto.getNtySubject()));
          selectCntSelectNtyListEntity.setNtySubject(StringUtils.setEmptyToNull(indto.getNtySubject()));

          if(paramEntity.getNtySubject() != null) {
        	  switch (paramEntity.getNtySubject()){
        	  case "1":
        	    // 式を評価した値が定数1と一致したときに実行される処理
        		  paramEntity.setNtySubject("重複登録アラート");
        		  selectCntSelectNtyListEntity.setNtySubject("重複登録アラート");
        	    break;
        	  case "2":
        	    // 式を評価した値が定数2と一致したときに実行される処理
        		  paramEntity.setNtySubject("重複申請アラート");
        		  selectCntSelectNtyListEntity.setNtySubject("重複申請アラート");
        	    break;
        	  case "3":
          	    // 式を評価した値が定数3と一致したときに実行される処理
          		  paramEntity.setNtySubject("ULT接続保留");
          		  selectCntSelectNtyListEntity.setNtySubject("ULT接続保留");
          	    break;
        	  case "4":
          	    // 式を評価した値が定数4と一致したときに実行される処理
          		  paramEntity.setNtySubject("FB回答(重複)");
          		  selectCntSelectNtyListEntity.setNtySubject("FB回答(重複)");
          	    break;
        	  case "5":
          	    // 式を評価した値が定数5と一致したときに実行される処理
          		  paramEntity.setNtySubject("FB回答(要確認)");
          		  selectCntSelectNtyListEntity.setNtySubject("FB回答(要確認)");
          	    break;
        	  case "6":
          	    // 式を評価した値が定数6と一致したときに実行される処理
          		  paramEntity.setNtySubject("FB回答(想定外)");
          		  selectCntSelectNtyListEntity.setNtySubject("FB回答(想定外)");
          	    break;
        	  case "7":
          	    // 式を評価した値が定数7と一致したときに実行される処理
          		  paramEntity.setNtySubject("親子整合性アラート");
          		  selectCntSelectNtyListEntity.setNtySubject("親子整合性アラート");
          	    break;
        	  case "8":
          	    // 式を評価した値が定数8と一致したときに実行される処理
          		  paramEntity.setNtySubject("グルーピング整合性アラート");
          		  selectCntSelectNtyListEntity.setNtySubject("グルーピング整合性アラート");
          	    break;
        	  case "9":
          	    // 式を評価した値が定数9と一致したときに実行される処理
          		  paramEntity.setNtySubject("自動承認アラート");
          		  selectCntSelectNtyListEntity.setNtySubject("自動承認アラート");
          	    break;
        	  case "10":
          	    // 式を評価した値が定数10と一致したときに実行される処理
          		  paramEntity.setNtySubject("実績整合性アラート");
          		  selectCntSelectNtyListEntity.setNtySubject("実績整合性アラート");
          	    break;
        	  case "11":
          	    // 式を評価した値が定数11と一致したときに実行される処理
          		  paramEntity.setNtySubject("データ整合性アラート");
          		  selectCntSelectNtyListEntity.setNtySubject("データ整合性アラート");
          	    break;
        	  case "12":
          	    // 式を評価した値が定数12と一致したときに実行される処理
          		  paramEntity.setNtySubject("担当外アラート");
          		  selectCntSelectNtyListEntity.setNtySubject("担当外アラート");
          	    break;
        	  case "13":
          	    // 式を評価した値が定数13と一致したときに実行される処理
          		  paramEntity.setNtySubject("長期承認待ち");
          		  selectCntSelectNtyListEntity.setNtySubject("長期承認待ち");
          	    break;
          }
        }
          //通知内容の検索値のセット、setEmptyToNullで空文字をNullに置換している。
          paramEntity.setNtyData(StringUtils.setEmptyToNull(indto.getNtyData()));
          selectCntSelectNtyListEntity.setNtyData(StringUtils.setEmptyToNull(indto.getNtyData()));

          //通知メモの検索値のセット、setEmptyToNullで空文字をNullに置換している。
          paramEntity.setNtyMemo(StringUtils.setEmptyToNull(indto.getNtyMemo()));
          selectCntSelectNtyListEntity.setNtyMemo(StringUtils.setEmptyToNull(indto.getNtyMemo()));

          //要チェックフラグのセット、
          paramEntity.setDataDupCheck(indto.isDataDupCheck());
          selectCntSelectNtyListEntity.setDataDupCheck(indto.isDataDupCheck());
          //要チェックフラグのセット、
          paramEntity.setUltRnkCheck(indto.isUltRnkCheck());
          selectCntSelectNtyListEntity.setUltRnkCheck(indto.isUltRnkCheck());
          //要チェックフラグのセット、
          paramEntity.setFbResCheck(indto.isFbResCheck());
          selectCntSelectNtyListEntity.setFbResCheck(indto.isFbResCheck());
          //要チェックフラグのセット、
          paramEntity.setConsCheck(indto.isConsCheck());
          selectCntSelectNtyListEntity.setConsCheck(indto.isConsCheck());
          //要チェックフラグのセット、
          paramEntity.setOthersCheck(indto.isOthersCheck());
          selectCntSelectNtyListEntity.setOthersCheck(indto.isOthersCheck());
          //要チェックフラグのセット、
          paramEntity.setOnlyCheck(indto.isOnlyCheck());
          selectCntSelectNtyListEntity.setOnlyCheck(indto.isOnlyCheck());
          //要チェックフラグのセット、
          paramEntity.setUnconCheck(indto.isUnconCheck());
          selectCntSelectNtyListEntity.setUnconCheck(indto.isUnconCheck());
          //要チェックフラグのセット、
          paramEntity.setUbderCheck(indto.isUbderCheck());
          selectCntSelectNtyListEntity.setUbderCheck(indto.isUbderCheck());
          //要チェックフラグのセット、
          paramEntity.setResolvCheck(indto.isResolvCheck());
          selectCntSelectNtyListEntity.setResolvCheck(indto.isResolvCheck());

          if(paramEntity.isDataDupCheck() == true ||  paramEntity.isUltRnkCheck()  == true ||  paramEntity.isFbResCheck()  == true || paramEntity.isConsCheck() == true || paramEntity.isOthersCheck() == true|| paramEntity.isOnlyCheck() == true) {
        	  paramEntity.setNtyBri("001");
        	  selectCntSelectNtyListEntity.setNtyBri("001");
          }

          if(paramEntity.isUnconCheck() == true || paramEntity.isUbderCheck() == true || paramEntity.isResolvCheck() == true) {
        	  paramEntity.setNtySts("1");
        	  selectCntSelectNtyListEntity.setNtySts("1");
          }


          //申請チャネルの検索値のセット、setEmptyToNullで空文字をNullに置換している。
//          paramEntity.setReqChl(StringUtils.setEmptyToNull(indto.getReqChl()));
//          selectCntSelectNtyListEntity.setReqChl(StringUtils.setEmptyToNull(indto.getReqChl()));
//          if(paramEntity.getReqChl() !=null) {
//	          if(paramEntity.getReqChl().equals("01")) {
//	        	  paramEntity.setReqChl("1");
//	        	  selectCntSelectNtyListEntity.setReqChl("1");
//	          }else if(paramEntity.getReqChl().equals("02")) {
//	        	  paramEntity.setReqChl("2");
//	        	  selectCntSelectNtyListEntity.setReqChl("2");
//	          }else if(paramEntity.getReqChl().equals("13")) {
//	        	  paramEntity.setReqChl("3");
//	        	  selectCntSelectNtyListEntity.setReqChl("3");
//	          }else if(paramEntity.getReqChl().equals("14")) {
//	        	  paramEntity.setReqChl("4");
//	        	  selectCntSelectNtyListEntity.setReqChl("4");
//	          }
//          }



          //申請日前部分の検索値のセット、setEmptyToNullで空文字をNullに置換している。
          paramEntity.setHisYmdhmsFrom(StringUtils.setEmptyToNull(indto.getHisYmdhmsFrom()));
          selectCntSelectNtyListEntity.setHisYmdhmsFrom(StringUtils.setEmptyToNull(indto.getHisYmdhmsFrom()));

//          //申請日前部分の検索値のセット、setEmptyToNullで空文字をNullに置換している。
//          paramEntity.setHisYmdhmsTo(StringUtils.setEmptyToNull(indto.getHisYmdhmsTo()));
//          selectCntSelectNtyListEntity.setHisYmdhmsTo(StringUtils.setEmptyToNull(indto.getHisYmdhmsTo()));


          //申請日前部分の検索値のセット、setEmptyToNullで空文字をNullに置換している。inOffset
          paramEntity.setInOffset(indto.getInOffset());
          selectCntSelectNtyListEntity.setInOffset(indto.getInOffset());

          //申請日前部分の検索値のセット、setEmptyToNullで空文字をNullに置換している。inLimit
          paramEntity.setInLimit(indto.getInLimit());
          selectCntSelectNtyListEntity.setInLimit(indto.getInLimit());

          //ソートIDのセット
          paramEntity.setInSortId(indto.getSortCondition());


          String workSortCondition = indto.getSortCondition();


          //日付チェック 開始日が終了日より後の場合
         if(indto.getHisYmdhmsTo() != null || indto.getHisYmdhmsFrom() != null) {
             //SimpleDateFormatで日付フォーマット設定
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
          try {
				if (sdf.parse(indto.getHisYmdhmsFrom()).compareTo((sdf.parse(indto.getHisYmdhmsTo()))) == 1) {
					indto.setBoolKnb("1");
					indto.setKensakuBool(false);
	        		return outdto;
				  }
			} catch (ParseException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
         }
          //入力_検索文字列  申請日がnullでないかのチェック。
          if(paramEntity.getHisYmdhmsFrom() != null) {
        	  indto.setInhisYmdhmsFrom(paramEntity.getHisYmdhmsFrom());
              	 //値がある場合：ハイフン除去
              	SelectHenkanListEntity haihunjokyo = new SelectHenkanListEntity("ハイフン除去");
              	haihunjokyo.setSearchHenkan(indto.getHisYmdhmsFrom());
                  //ハイフン除去結果を格納
                  List<SelectHenkanListEntity> selectKnazi = dao.select(haihunjokyo);
                  for (SelectHenkanListEntity haijokyo : selectKnazi) {
                	paramEntity.setHisYmdhmsFrom(haijokyo.getSearchHenkan());
                	selectCntSelectNtyListEntity.setHisYmdhmsFrom(haijokyo.getSearchHenkan());
                  }
              }

          //申請日後部分の検索値のセット、setEmptyToNullで空文字をNullに置換している。
          paramEntity.setHisYmdhmsTo(StringUtils.setEmptyToNull(indto.getHisYmdhmsTo()));
          //入力_検索文字列  申請日がnullでないかのチェック。
          if(paramEntity.getHisYmdhmsTo() != null) {
        	  indto.setInhisYmdhmsTo(paramEntity.getHisYmdhmsTo());
              	 //値がある場合：ハイフン除去
              	SelectHenkanListEntity haihunjokyo = new SelectHenkanListEntity("ハイフン除去");
              	haihunjokyo.setSearchHenkan(indto.getHisYmdhmsTo());
                  //ハイフン除去結果を格納
                  List<SelectHenkanListEntity> selectKnazi = dao.select(haihunjokyo);
                  for (SelectHenkanListEntity haijokyo : selectKnazi) {
                  	paramEntity.setHisYmdhmsTo(haijokyo.getSearchHenkan());
                  	selectCntSelectNtyListEntity.setHisYmdhmsTo(haijokyo.getSearchHenkan());

                  }
              }


          //入力_検索文字列  施設名がnullでないかのチェック。
         // selectParamSelectReqList =dao.select(paramEntity);

          selectParamSelectReqList  = dao.select(selectCntSelectNtyListEntity);
          //1000件以上の場合のエラー
    	    if (selectParamSelectReqList.get(0).getCntReq() > selectParamNM011List.get(0).getValue()) {//deptListEntity.size()
    	    	indto.setBoolKnb("2");
        		return outdto;
    	    }
          indto.initPageInfo(indto.getPageCntCur(), selectParamSelectReqList.get(0).getCntReq(), selectParamNM011List.get(1).getValue());
          paramEntity.setInOffset(indto.getLineCntStart() - 1);
          paramEntity.setInLimit(selectParamNM011List.get(1).getValue());
              //画面初期表示時の帳票一覧を取得する
              List<SRdmNtyListEntity> deptListEntity = dao.select(paramEntity);



             // for(int i = 0;i < 11; i++) {
              	 for (SRdmNtyListEntity entity : deptListEntity) {
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
                        }
                	//dataRecord.setReqYmdhmsTo(entity.getHisYmdhmsTo());
                	}else {
                		dataRecord.setHisYmdhmsTo(" ");
                	}

              		// 通知分類
                	if(entity.getNtyBri() != null) {
                	dataRecord.setNtyBri(entity.getNtyBri());
                	}else {
                	dataRecord.setNtyBri(" ");
                	}

              		// 通知件名
                	if(entity.getNtySubject() != null) {
                	dataRecord.setNtySubject(entity.getNtySubject());
                	}else {
                	dataRecord.setNtySubject(" ");
                	}

              		// 通知内容
                	if(entity.getNtyData() != null) {
                	dataRecord.setNtyData(entity.getNtyData());
                	//dataRecord.setNtyData(entity.getNtyData().replace("\\n", "<br>"));
                	}else {
                	dataRecord.setNtyData(" ");
                	}

              		// メモ
                	if(entity.getNtyMemo() != null) {
                	dataRecord.setNtyMemo(entity.getNtyMemo());
                	}else {
                	dataRecord.setNtyMemo(" ");
                	}

              		// 通知ステータス
                	if(entity.getNtySts() != null) {
                	dataRecord.setNtySts(entity.getNtySts());
                	}else {
                	dataRecord.setNtySts(" ");
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
                        }
                    	//dataRecord.setAPR_YMDHMS(entity.getAPR_YMDHMS());
                    	}else {
                    		dataRecord.setSsUpdYmdhms(" ");
                    	}
                       //dataRecord.setAPR_YMDHMS(entity.getAPR_YMDHMS());


//                    // 種別
//                	if(entity.getReqType() != null) {
//                		if(entity.getReqType().equals("01") || entity.getReqType().equals("02") || entity.getReqType().equals("03") || entity.getReqType().equals("04") || entity.getReqType().equals("11") || entity.getReqType().equals("12") || entity.getReqType().equals("13") || entity.getReqType().equals("21")) {
//                			dataRecord.setSbt("施設");
//                		}else if(entity.getReqType().equals("31") || entity.getReqType().equals("32") || entity.getReqType().equals("33") || entity.getReqType().equals("34") || entity.getReqType().equals("41") || entity.getReqType().equals("42") || entity.getReqType().equals("43") || entity.getReqType().equals("44") || entity.getReqType().equals("51")) {
//                			dataRecord.setSbt("医師");
//                		}else {
//                    		dataRecord.setSbt(" ");
//                    	}
//                	}else {
//                		dataRecord.setSbt(" ");
//                	}

                       //dataRecord.setReqId(entity.getReqId());

                       //dataRecord.setReqYmdhms(entity.getReqYmdhms()); /*setDeptCode部分を修正している(DepjtK)*/

                    // 連携種別
//                	if(entity.getReqChl() != null) {
//                		if(entity.getReqChl().equals("1") || entity.getReqChl().equals("2")) {
//                			dataRecord.setReqSbt("手動");
//                		}else if(entity.getReqChl().equals("3") || entity.getReqChl().equals("4")) {
//                			dataRecord.setReqSbt("ULT連携");
//                		}else if(entity.getReqChl().equals("")){
//                			dataRecord.setReqSbt(" ");
//                		}else {
//                			dataRecord.setReqSbt(" ");
//                		}
//                	}else {
//                		dataRecord.setReqSbt(" ");
//                	}

                       //dataRecord.setreqChl(entity.getreqChl());
                    // 申請区分 コードの値のみの取得
//                	if(entity.getReqType() != null) {
//                	dataRecord.setReqType(entity.getReqType());
//                	}else {
//                		dataRecord.setReqType(" ");
//                	}
                	// 申請区分　コードの値を文字に変換している
//                	if(entity.getReqType() != null) {
//                	dataRecord.setReqType(entity.getReqType());
//                	}else {
//                		dataRecord.setReqType(" ");
//                	}
//                    // 申請ステータス
//                	if(entity.getReqType() != null) {
//                		if(entity.getReqType().equals("01")) {
//                			dataRecord.setReqType("施設新規作成");
//                		}else if(entity.getReqType().equals("02")) {
//                			dataRecord.setReqType("施設情報更新");
//                		}else if(entity.getReqType().equals("03")) {
//                			dataRecord.setReqType("施設削除");
//                		}else if(entity.getReqType().equals("04")) {
//                			dataRecord.setReqType("施設復活");
//                		}else if(entity.getReqType().equals("11")) {
//                			dataRecord.setReqType("施設紐付け新規");
//                		}else if(entity.getReqType().equals("12")) {
//                			dataRecord.setReqType("施設紐付け変更");
//                		}else if(entity.getReqType().equals("13")) {
//                			dataRecord.setReqType("施設紐付け削除");
//                		}else if(entity.getReqType().equals("21")) {
//                			dataRecord.setReqType("施設来期用項目更新");
//                		}else if(entity.getReqType().equals("31")) {
//                			dataRecord.setReqType("医師新規作成");
//                		}else if(entity.getReqType().equals("32")) {
//                			dataRecord.setReqType("医師情報更新");
//                		}else if(entity.getReqType().equals("33")) {
//                			dataRecord.setReqType("医師削除");
//                		}else if(entity.getReqType().equals("34")) {
//                			dataRecord.setReqType("医師復活");
//                		}else if(entity.getReqType().equals("41")) {
//                			dataRecord.setReqType("医師勤務先追加");
//                		}else if(entity.getReqType().equals("42")) {
//                			dataRecord.setReqType("医療機関への異動");
//                		}else if(entity.getReqType().equals("43")) {
//                			dataRecord.setReqType("医療機関以外への異動");
//                		}else if(entity.getReqType().equals("44")) {
//                			dataRecord.setReqType("医師勤務先削除");
//                		}else if(entity.getReqType().equals("51")) {
//                			dataRecord.setReqType("勤務先情報更新");
//                		}else {
//                			dataRecord.setReqType(" ");
//                		}
//                	}else {
//                		dataRecord.setReqSts(" ");
//                	}

                    // 申請ステータス
//                	if(entity.getReqSts() != null) {
//                	dataRecord.setReqSts(entity.getReqSts());
//                	}else {
//                		dataRecord.setReqSts(" ");
//                	}
                	// 申請ステータス
//                	if(entity.getReqSts() != null) {
//                		if(entity.getReqSts().equals("01")) {
//                			dataRecord.setReqSts("保存済み");
//                		}else if(entity.getReqSts().equals("02")) {
//                			dataRecord.setReqSts("却下済み");
//                		}else if(entity.getReqSts().equals("03")) {
//                			dataRecord.setReqSts("承認待ち");
//                		}else if(entity.getReqSts().equals("04")) {
//                			dataRecord.setReqSts("承認済み");
//                		}else if(entity.getReqSts().equals("11")) {
//                			dataRecord.setReqSts("ULT申請待ち");
//                		}else if(entity.getReqSts().equals("12")) {
//                			dataRecord.setReqSts("ULT却下済み");
//                		}else if(entity.getReqSts().equals("13")) {
//                			dataRecord.setReqSts("ULT承認待ち");
//                		}else if(entity.getReqSts().equals("14")) {
//                			dataRecord.setReqSts("ULT承認済み");
//                		}else if(entity.getReqSts().equals("21")) {
//                			dataRecord.setReqSts("FB適用承認済み");
//                		}else if(entity.getReqSts().equals("22")) {
//                			dataRecord.setReqSts("FB結果確認");
//                		}else if(entity.getReqSts().equals("31")) {
//                			dataRecord.setReqSts("MDM処理中");
//                		}else if(entity.getReqSts().equals("32")) {
//                			dataRecord.setReqSts("MDM適用保留");
//                		}else if(entity.getReqSts().equals("33")) {
//                			dataRecord.setReqSts("MDM登録済み");
//                		}else if(entity.getReqSts().equals("34")) {
//                			dataRecord.setReqSts("MDM却下");
//                		}else {
//                    		dataRecord.setReqType(" ");
//                    	}
//                	}


                       //dataRecord.setInsFormalName(entity.getInsFormalName());
                    // 申請者名
                   	if(entity.getReqJgiName() != null) {
                    	dataRecord.setReqJgiName(entity.getReqJgiName());
                    	}else {
                    		dataRecord.setReqJgiName(" ");
                    	}
                       //dataRecord.setReqJgiName(entity.getReqJgiName());





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
    public BaseDTO page(NM011DTO indto) throws ParseException {
        BaseDTO outdto = indto;
        // START UOC

        outdto = search(indto);

        // END UOC
        return outdto;
    }
}
