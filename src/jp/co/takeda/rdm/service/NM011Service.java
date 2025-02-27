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
import jp.co.takeda.rdm.entity.SRdmJkrSosReqChlEntiry;
import jp.co.takeda.rdm.entity.SRdmJkrSosReqStsEntiry;
import jp.co.takeda.rdm.entity.SRdmJkrSosReqTypeEntiry;

import jp.co.takeda.rdm.entity.join.SelectCntSelectReqListEntity;
import jp.co.takeda.rdm.entity.join.SelectHenkanListEntity;
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
     	if("NM001".equals(loginInfo.getPreScreenId())) {
     		//if(indto.getReqYmdhmsTo().length() == 8) {
//         	indto.setReqYmdhmsTo(indto.getReqYmdhmsTo().substring(0, 4)+ '-' + indto.getReqYmdhmsTo().substring(4, 6)+ '-' + indto.getReqYmdhmsTo().substring(6, 8));
//         	indto.setReqYmdhmsFrom(indto.getReqYmdhmsFrom().substring(0, 4)+ '-' + indto.getReqYmdhmsFrom().substring(4, 6)+ '-' + indto.getReqYmdhmsFrom().substring(6, 8));
         	indto.setReqYmdhmsTo(indto.getInreqYmdhmsTo());
         	indto.setReqYmdhmsFrom(indto.getInreqYmdhmsFrom());

     		//}
     	}
     	if(!"NM001".equals(loginInfo.getPreScreenId())) {
        for (MRdmComCalUsrEntity entity : SelectComCalUsrKako) {
            //検索結果_本日日付
            indto.setInreqYmdhmsFrom(sdf.format(entity.getCalDate()));
            indto.setKnYmdhmsFrom(sdf.format(entity.getCalDate()));
        }
        for (MRdmComCalUsrEntity entity : SelectComCalUsrToday) {
            //検索結果_過去日付
            indto.setInreqYmdhmsTo(sdf.format(entity.getCalDate()));
            indto.setKnYmdhmsTo(sdf.format(entity.getCalDate()));
        }
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

    //ドロップダウンリスト-申請チャネル
    private void  reqChlDrop(NM011DTO indto){
        // START UOC
    		SRdmJkrSosReqChlEntiry sRdmJkrSosReqChlEntiry = new SRdmJkrSosReqChlEntiry();
            List<SRdmJkrSosReqChlEntiry> jkrSosReqChlMap = dao.select(sRdmJkrSosReqChlEntiry);
            LinkedHashMap<String, String> mapReqType = new LinkedHashMap<String, String>();
            mapReqType.put(""," ");//nullの確認
            for (SRdmJkrSosReqChlEntiry outEntity : jkrSosReqChlMap) {
            	if(outEntity.getValue1().equals("1") || outEntity.getValue1().equals("2")) {
            		outEntity.setValue1("0" + outEntity.getValue1());
            	}
            	if(outEntity.getValue1().equals("3") || outEntity.getValue1().equals("4")) {
            		outEntity.setValue1("1" + outEntity.getValue1());
            	}
            	mapReqType.put(outEntity.getValue1(), outEntity.getValue1Kanj());
            }
            indto.setJkrSosReqChlMap(mapReqType);
//          if(indto.getReqSbt() != null) {
//          if(!indto.getReqSbt().equals("")) {
//              indto.setReqChl(" ");
//          }
//      }

    }

  //ドロップダウンリスト-連携種別
    private void  reqSbtDrop(NM011DTO indto) {
    	LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();
        loginInfo.getPreScreenId();
        // START UOC
        LinkedHashMap<String, String> mapAddr = new LinkedHashMap<String, String>();
        mapAddr.put(null,"全て");
        mapAddr.put("0","手動");
        mapAddr.put("1","ULT連携");

        indto.setJkrSosReqSbtMap(mapAddr);
        if("NM001".equals(loginInfo.getPreScreenId())) {
        if(indto.getReqChl().equals("1")) {
            indto.setReqSbt("0");
            indto.setReqChl("01");
        }
        if(indto.getReqChl().equals("2")) {
            indto.setReqSbt("0");
            indto.setReqChl("02");
        }
        if(indto.getReqChl().equals("3")) {
            indto.setReqSbt("1");
            indto.setReqChl("13");
        }
        if(indto.getReqChl().equals("4")) {
            indto.setReqSbt("1");
            indto.setReqChl("14");
        }
        }
        // END UOC
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
        reqSbtDrop(indto);
        reqTypeDrop(indto);
        reqStsDrop(indto);
        insSbtDrop(indto);
        insClassDrop(indto);
        hoInsTypeDrop(indto);
        docTypeDrop(indto);
        jobFormDrop(indto);
        reqChlDrop(indto);
        FbReqFlg(indto);
        FbPrcType(indto);
        // ページ数(現在:１ページ目から)
        indto.setPageCntCur(1);
        indto.setPageFlag("1");
        if("NM001".equals(indto.getPreScreenId())) {
        	outdto = search(indto);
        }

        // END UOC
        return outdto;

    }

	public BaseDTO search(NM011DTO indto) throws ParseException{
		BaseDTO outdto = indto;
		SRdmReqListEntity paramEntity = new SRdmReqListEntity();
      //  List<NM011Entity> selectTestEntity = dao.select(paramEntity);
      //  indto.setTest(selectTestEntity.get(0).getTest());
		indto.setPageFlag("0");
        addrDrop(indto);
        cal(indto);
        sbtDrop(indto);
        reqChlDrop(indto);
        reqSbtDrop(indto);
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
        List<CatSnseiComboDataList> catSnseiComboDataList = new ArrayList<CatSnseiComboDataList>();

  		SelectParamNM011Entity selectParamReqNM011Entity = new SelectParamNM011Entity();
  		List<SelectParamNM011Entity> selectParamNM011List;
  		selectParamNM011List = dao.select(selectParamReqNM011Entity);

  		//241002-000014 テスト用申請ID

          SelectCntSelectReqListEntity selectCntSelectReqListEntity = new SelectCntSelectReqListEntity();
          List<SelectCntSelectReqListEntity> selectParamSelectReqList;

          //アドミンflagの検索値のセット、setEmptyToNullで空文字をNullに置換している。
          paramEntity.setMrAdminFlg(StringUtils.setEmptyToNull(indto.getMrAdminFlg()));
          selectCntSelectReqListEntity.setMrAdminFlg(StringUtils.setEmptyToNull(indto.getMrAdminFlg()));

          //アドミンflagの検索値のセット、setEmptyToNullで空文字をNullに置換している。
          paramEntity.setJgiNo(StringUtils.setEmptyToNull(indto.getJgiNo()));
          selectCntSelectReqListEntity.setJgiNo(StringUtils.setEmptyToNull(indto.getJgiNo()));

          //申請IDの検索値のセット、setEmptyToNullで空文字をNullに置換している。
          paramEntity.setReqId(StringUtils.setEmptyToNull(indto.getReqId()));
          selectCntSelectReqListEntity.setReqId(StringUtils.setEmptyToNull(indto.getReqId()));

          //種別の検索値のセット、setEmptyToNullで空文字をNullに置換している。
          paramEntity.setSbt(StringUtils.setEmptyToNull(indto.getSbt()));
          selectCntSelectReqListEntity.setSbt(StringUtils.setEmptyToNull(indto.getSbt()));

          //部門ランクの検索値のセット、setEmptyToNullで空文字をNullに置換している。-管理者のみ
          paramEntity.setBumonRank(StringUtils.setEmptyToNull(indto.getBumonRank()));
          selectCntSelectReqListEntity.setBumonRank(StringUtils.setEmptyToNull(indto.getBumonRank()));

          //組織コードの検索値のセット、setEmptyToNullで空文字をNullに置換している。-管理者のみ
          paramEntity.setBumonRyakuName(StringUtils.setEmptyToNull(indto.getBumonRyakuName()));
          selectCntSelectReqListEntity.setBumonRyakuName(StringUtils.setEmptyToNull(indto.getBumonRyakuName()));
         //paramEntity.setReqBrCode("010");

          //組織名称の検索値のセット、setEmptyToNullで空文字をNullに置換している。-管理者のみ
          paramEntity.setBrCode(StringUtils.setEmptyToNull(indto.getBrCode()));
          selectCntSelectReqListEntity.setBrCode(StringUtils.setEmptyToNull(indto.getBrCode()));
         //paramEntity.setReqBrCode("010");

          //申請者所属リージョン(医薬支店C)の検索値のセット、setEmptyToNullで空文字をNullに置換している。-管理者のみ
          paramEntity.setBrCode(StringUtils.setEmptyToNull(indto.getBrCode()));
          selectCntSelectReqListEntity.setBrCode(StringUtils.setEmptyToNull(indto.getBrCode()));

          //申請者所属エリア(医薬営業所C)の検索値のセット、setEmptyToNullで空文字をNullに置換している。-管理者のみ
          paramEntity.setDistCode(StringUtils.setEmptyToNull(indto.getDistCode()));
          selectCntSelectReqListEntity.setDistCode(StringUtils.setEmptyToNull(indto.getDistCode()));

          //申請者名の検索値のセット、setEmptyToNullで空文字をNullに置換している。-管理者のみ
          paramEntity.setReqJgiName(StringUtils.setEmptyToNull(indto.getReqJgiName()));
          selectCntSelectReqListEntity.setReqJgiName(StringUtils.setEmptyToNull(indto.getReqJgiName()));

          //申請者従業員番号の検索値のセット、setEmptyToNullで空文字をNullに置換している。-MRのみ  //8830034
          paramEntity.setReqJgiNo(StringUtils.setEmptyToNull(indto.getReqJgiNo()));
          selectCntSelectReqListEntity.setReqJgiNo(StringUtils.setEmptyToNull(indto.getReqJgiNo()));
          //paramEntity.setReqJgiNo("8830034");//test用

          //申請者所属の検索値のセット、setEmptyToNullで空文字をNullに置換している。-管理者のみ
          paramEntity.setReqShz(StringUtils.setEmptyToNull(indto.getBumonRyakuName()));
          selectCntSelectReqListEntity.setReqShz(StringUtils.setEmptyToNull(indto.getBumonRyakuName()));
          //paramEntity.setReqShz(StringUtils.setEmptyToNull(indto.getReqShz()));
          //selectCntSelectReqListEntity.setReqShz(StringUtils.setEmptyToNull(indto.getReqShz()));
          //都道府県の検索値のセット、setEmptyToNullで空文字をNullに置換している。
          paramEntity.setADdrCodePref(StringUtils.setEmptyToNull(indto.getADdrCodePref()));
          selectCntSelectReqListEntity.setADdrCodePref(StringUtils.setEmptyToNull(indto.getADdrCodePref()));

          //申請区分の検索値のセット、setEmptyToNullで空文字をNullに置換している。
          paramEntity.setReqType(StringUtils.setEmptyToNull(indto.getReqType()));
          selectCntSelectReqListEntity.setReqType(StringUtils.setEmptyToNull(indto.getReqType()));

          //都道府県の検索値のセット、setEmptyToNullで空文字をNullに置換している。
          paramEntity.setADdrCodePref(StringUtils.setEmptyToNull(indto.getADdrCodePref()));
          selectCntSelectReqListEntity.setADdrCodePref(StringUtils.setEmptyToNull(indto.getADdrCodePref()));

          //施設IDの検索値のセット、setEmptyToNullで空文字をNullに置換している。
          paramEntity.setInsNo(StringUtils.setEmptyToNull(indto.getInsNo()));
          selectCntSelectReqListEntity.setInsNo(StringUtils.setEmptyToNull(indto.getInsNo()));

          //医師IDの検索値のセット、setEmptyToNullで空文字をNullに置換している。
          paramEntity.setDocNo(StringUtils.setEmptyToNull(indto.getDocNo()));
          selectCntSelectReqListEntity.setDocNo(StringUtils.setEmptyToNull(indto.getDocNo()));

          //申請ステータスの検索値のセット、setEmptyToNullで空文字をNullに置換している。
          paramEntity.setReqSts(StringUtils.setEmptyToNull(indto.getReqSts()));
          selectCntSelectReqListEntity.setReqSts(StringUtils.setEmptyToNull(indto.getReqSts()));

          //施設分類の検索値のセット、setEmptyToNullで空文字をNullに置換している。
          paramEntity.setInsClass(StringUtils.setEmptyToNull(indto.getInsClass()));
          selectCntSelectReqListEntity.setInsClass(StringUtils.setEmptyToNull(indto.getInsClass()));

          //施設種別の検索値のセット、setEmptyToNullで空文字をNullに置換している。
          paramEntity.setInsSbt(StringUtils.setEmptyToNull(indto.getInsSbt()));
          selectCntSelectReqListEntity.setInsSbt(StringUtils.setEmptyToNull(indto.getInsSbt()));

          //医師種別の検索値のセット、setEmptyToNullで空文字をNullに置換している。
          paramEntity.setDocType(StringUtils.setEmptyToNull(indto.getDocType()));
          selectCntSelectReqListEntity.setDocType(StringUtils.setEmptyToNull(indto.getDocType()));

          //連携種別の検索値のセット、setEmptyToNullで空文字をNullに置換している。
          paramEntity.setReqSbt(StringUtils.setEmptyToNull(indto.getReqSbt()));
          selectCntSelectReqListEntity.setReqSbt(StringUtils.setEmptyToNull(indto.getReqSbt()));

          //申請チャネルの検索値のセット、setEmptyToNullで空文字をNullに置換している。
          paramEntity.setReqChl(StringUtils.setEmptyToNull(indto.getReqChl()));
          selectCntSelectReqListEntity.setReqChl(StringUtils.setEmptyToNull(indto.getReqChl()));
          if(paramEntity.getReqChl() !=null) {
          if(paramEntity.getReqChl().equals("01")) {
        	  paramEntity.setReqChl("1");
        	  selectCntSelectReqListEntity.setReqChl("1");
          }else if(paramEntity.getReqChl().equals("02")) {
        	  paramEntity.setReqChl("2");
        	  selectCntSelectReqListEntity.setReqChl("2");
          }else if(paramEntity.getReqChl().equals("13")) {
        	  paramEntity.setReqChl("3");
        	  selectCntSelectReqListEntity.setReqChl("3");
          }else if(paramEntity.getReqChl().equals("14")) {
        	  paramEntity.setReqChl("4");
        	  selectCntSelectReqListEntity.setReqChl("4");
          }
          }


          //勤務形態の検索値のセット、setEmptyToNullで空文字をNullに置換している。
          paramEntity.setJobForm(StringUtils.setEmptyToNull(indto.getJobForm()));
          selectCntSelectReqListEntity.setJobForm(StringUtils.setEmptyToNull(indto.getJobForm()));

          //対象区分の検索値のセット、setEmptyToNullで空文字をNullに置換している。
          paramEntity.setHoInsType(StringUtils.setEmptyToNull(indto.getHoInsType()));
          selectCntSelectReqListEntity.setHoInsType(StringUtils.setEmptyToNull(indto.getHoInsType()));

          //施設名の検索値のセット、setEmptyToNullで空文字をNullに置換している。
          paramEntity.setInsKanjiSrch(StringUtils.setEmptyToNull(indto.getInsKanjiSrch()));
          selectCntSelectReqListEntity.setInsKanjiSrch(StringUtils.setEmptyToNull(indto.getInsKanjiSrch()));

          //医師名の検索値のセット、setEmptyToNullで空文字をNullに置換している。
          paramEntity.setDocKanj(StringUtils.setEmptyToNull(indto.getDocKanj()));
          selectCntSelectReqListEntity.setDocKanj(StringUtils.setEmptyToNull(indto.getDocKanj()));

          //申請コメントの検索値のセット、setEmptyToNullで空文字をNullに置換している。
          paramEntity.setReqComment(StringUtils.setEmptyToNull(indto.getReqComment()));
          selectCntSelectReqListEntity.setReqComment(StringUtils.setEmptyToNull(indto.getReqComment()));

          //承認・却下コメントの検索値のセット、setEmptyToNullで空文字をNullに置換している。
          paramEntity.setAprComment(StringUtils.setEmptyToNull(indto.getAprComment()));
          selectCntSelectReqListEntity.setAprComment(StringUtils.setEmptyToNull(indto.getAprComment()));

          //申請日前部分の検索値のセット、setEmptyToNullで空文字をNullに置換している。
          paramEntity.setReqYmdhmsFrom(StringUtils.setEmptyToNull(indto.getReqYmdhmsFrom()));
          selectCntSelectReqListEntity.setReqYmdhmsFrom(StringUtils.setEmptyToNull(indto.getReqYmdhmsFrom()));

          //申請日前部分の検索値のセット、setEmptyToNullで空文字をNullに置換している。inOffset
          paramEntity.setInOffset(indto.getInOffset());
          selectCntSelectReqListEntity.setInOffset(indto.getInOffset());

          //申請日前部分の検索値のセット、setEmptyToNullで空文字をNullに置換している。inLimit
          paramEntity.setInLimit(indto.getInLimit());
          selectCntSelectReqListEntity.setInLimit(indto.getInLimit());

          //ソートIDのセット
          paramEntity.setInSortId(indto.getSortCondition());


          String workSortCondition = indto.getSortCondition();

        //SimpleDateFormatで日付フォーマット設定
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
          //日付チェック 開始日が終了日より後の場合
          try {
			if (!sdf.parse(indto.getReqYmdhmsFrom()).before(sdf.parse(indto.getReqYmdhmsTo()))) {
				indto.setBoolKnb("1");
				indto.setKensakuBool(false);
        		return outdto;
			  }
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

          //入力_検索文字列  申請日がnullでないかのチェック。
          if(paramEntity.getReqYmdhmsFrom() != null) {
        	  indto.setInreqYmdhmsFrom(paramEntity.getReqYmdhmsFrom());
              	 //値がある場合：ハイフン除去
              	SelectHenkanListEntity haihunjokyo = new SelectHenkanListEntity("ハイフン除去");
              	haihunjokyo.setSearchHenkan(indto.getReqYmdhmsFrom());
                  //ハイフン除去結果を格納
                  List<SelectHenkanListEntity> selectKnazi = dao.select(haihunjokyo);
                  for (SelectHenkanListEntity haijokyo : selectKnazi) {
                	paramEntity.setReqYmdhmsFrom(haijokyo.getSearchHenkan());
                	selectCntSelectReqListEntity.setReqYmdhmsFrom(haijokyo.getSearchHenkan());
                  }
              }

          //申請日後部分の検索値のセット、setEmptyToNullで空文字をNullに置換している。
          paramEntity.setReqYmdhmsTo(StringUtils.setEmptyToNull(indto.getReqYmdhmsTo()));
          //入力_検索文字列  申請日がnullでないかのチェック。
          if(paramEntity.getReqYmdhmsTo() != null) {
        	  indto.setInreqYmdhmsTo(paramEntity.getReqYmdhmsTo());
              	 //値がある場合：ハイフン除去
              	SelectHenkanListEntity haihunjokyo = new SelectHenkanListEntity("ハイフン除去");
              	haihunjokyo.setSearchHenkan(indto.getReqYmdhmsTo());
                  //ハイフン除去結果を格納
                  List<SelectHenkanListEntity> selectKnazi = dao.select(haihunjokyo);
                  for (SelectHenkanListEntity haijokyo : selectKnazi) {
                  	paramEntity.setReqYmdhmsTo(haijokyo.getSearchHenkan());
                  	selectCntSelectReqListEntity.setReqYmdhmsTo(haijokyo.getSearchHenkan());

                  }
              }

          //入力_検索文字列  施設名がnullでないかのチェック。
          if(paramEntity.getInsKanjiSrch() != null) {
        	  indto.setInsKanjiSrch(paramEntity.getInsKanjiSrch());
              	 //値がある場合：ハイフン除去
              	SelectHenkanListEntity haihunjokyo = new SelectHenkanListEntity("漢字変換");
              	haihunjokyo.setSearchHenkan(indto.getInsKanjiSrch());
                  //漢字変換
                  List<SelectHenkanListEntity> selectKnazi = dao.select(haihunjokyo);
                  //漢字変換後の値をセット
                   SelectHenkanListEntity zenkaku = selectKnazi.get(0);
                   //タイプ：全角変換をセット
                   zenkaku.setHenkanType("全角変換");
                   //全角変換
                  List<SelectHenkanListEntity> selectKnazi2 = dao.select(haihunjokyo);
                  //両変換後の値をセット
                  for (SelectHenkanListEntity haijokyo : selectKnazi2) {
                    	paramEntity.setInsKanjiSrch(haijokyo.getSearchHenkan());
                    	selectCntSelectReqListEntity.setInsKanjiSrch(haijokyo.getSearchHenkan());

                    }
              }
          //入力_検索文字列  施設名がnullでないかのチェック。
         // selectParamSelectReqList =dao.select(paramEntity);

          selectParamSelectReqList  = dao.select(selectCntSelectReqListEntity);
          indto.initPageInfo(indto.getPageCntCur(), selectParamSelectReqList.get(0).getCntReq(), selectParamNM011List.get(1).getValue());
          paramEntity.setInOffset(indto.getLineCntStart() - 1);
          paramEntity.setInLimit(selectParamNM011List.get(1).getValue());
              //画面初期表示時の帳票一覧を取得する
              List<SRdmReqListEntity> deptListEntity = dao.select(paramEntity);

              //1000件以上の場合のエラー
        	    if (deptListEntity.size() > selectParamNM011List.get(0).getValue()) {//deptListEntity.size()
        	    	indto.setBoolKnb("2");
            		return outdto;
        	    }

             // for(int i = 0;i < 11; i++) {
              	 for (SRdmReqListEntity entiry : deptListEntity) {
              		CatSnseiComboDataList dataRecord = new CatSnseiComboDataList();

              		// 申請ID
                	if(entiry.getReqId() != null) {
                	dataRecord.setReqId(entiry.getReqId());
                	}else {
                	dataRecord.setReqId(" ");
                	}

                    // 種別
                	if(entiry.getReqType() != null) {
                		if(entiry.getReqType().equals("01") || entiry.getReqType().equals("02") || entiry.getReqType().equals("03") || entiry.getReqType().equals("04") || entiry.getReqType().equals("11") || entiry.getReqType().equals("12") || entiry.getReqType().equals("13") || entiry.getReqType().equals("21")) {
                			dataRecord.setSbt("施設");
                		}else if(entiry.getReqType().equals("31") || entiry.getReqType().equals("32") || entiry.getReqType().equals("33") || entiry.getReqType().equals("34") || entiry.getReqType().equals("41") || entiry.getReqType().equals("42") || entiry.getReqType().equals("43") || entiry.getReqType().equals("44") || entiry.getReqType().equals("51")) {
                			dataRecord.setSbt("医師");
                		}else {
                    		dataRecord.setSbt(" ");
                    	}
                	}else {
                		dataRecord.setSbt(" ");
                	}

                       //dataRecord.setReqId(entiry.getReqId());

                    // 申請日
                	if(entiry.getReqYmdhmsTo() != null) {
                        if(entiry.getReqYmdhmsTo().length() == 8) {
                        	dataRecord.setReqYmdhmsTo(entiry.getReqYmdhmsTo().substring(0, 4)+ '/' + entiry.getReqYmdhmsTo().substring(4, 6)+ '/' + entiry.getReqYmdhmsTo().substring(6, 8));
                        }else if(entiry.getReqYmdhmsTo().length() == 12) {
                        	dataRecord.setReqYmdhmsTo(entiry.getReqYmdhmsTo().substring(0, 4)+ '/' + entiry.getReqYmdhmsTo().substring(4, 6)+ '/' + entiry.getReqYmdhmsTo().substring(6, 8)+ ' ' + entiry.getReqYmdhmsTo().substring(8, 10)+ ':' + entiry.getReqYmdhmsTo().substring(10, 12));
                        }else if(entiry.getReqYmdhmsTo().length() == 14) {
                        	dataRecord.setReqYmdhmsTo(entiry.getReqYmdhmsTo().substring(0, 4)+ '/' + entiry.getReqYmdhmsTo().substring(4, 6)+ '/' + entiry.getReqYmdhmsTo().substring(6, 8)+ ' ' + entiry.getReqYmdhmsTo().substring(8, 10)+ ':' + entiry.getReqYmdhmsTo().substring(10, 12)+ ':' + entiry.getReqYmdhmsTo().substring(12, 14));
                        }
                	//dataRecord.setReqYmdhmsTo(entiry.getReqYmdhmsTo());
                	}else {
                		dataRecord.setReqYmdhmsTo(" ");
                	}
                       //dataRecord.setReqYmdhms(entiry.getReqYmdhms()); /*setDeptCode部分を修正している(DepjtK)*/

                    // 連携種別
                	if(entiry.getReqChl() != null) {
                		if(entiry.getReqChl().equals("1") || entiry.getReqChl().equals("2")) {
                			dataRecord.setReqSbt("手動");
                		}else if(entiry.getReqChl().equals("3") || entiry.getReqChl().equals("4")) {
                			dataRecord.setReqSbt("ULT連携");
                		}else if(entiry.getReqChl().equals("")){
                			dataRecord.setReqSbt(" ");
                		}else {
                			dataRecord.setReqSbt(" ");
                		}
                	}else {
                		dataRecord.setReqSbt(" ");
                	}

                       //dataRecord.setreqChl(entiry.getreqChl());
                    // 申請区分 コードの値のみの取得
//                	if(entiry.getReqType() != null) {
//                	dataRecord.setReqType(entiry.getReqType());
//                	}else {
//                		dataRecord.setReqType(" ");
//                	}
                	// 申請区分　コードの値を文字に変換している
                	if(entiry.getReqType() != null) {
                	dataRecord.setReqType(entiry.getReqType());
                	}else {
                		dataRecord.setReqType(" ");
                	}
                    // 申請ステータス
                	if(entiry.getReqType() != null) {
                		if(entiry.getReqType().equals("01")) {
                			dataRecord.setReqType("施設新規作成");
                		}else if(entiry.getReqType().equals("02")) {
                			dataRecord.setReqType("施設情報更新");
                		}else if(entiry.getReqType().equals("03")) {
                			dataRecord.setReqType("施設削除");
                		}else if(entiry.getReqType().equals("04")) {
                			dataRecord.setReqType("施設復活");
                		}else if(entiry.getReqType().equals("11")) {
                			dataRecord.setReqType("施設紐付け新規");
                		}else if(entiry.getReqType().equals("12")) {
                			dataRecord.setReqType("施設紐付け変更");
                		}else if(entiry.getReqType().equals("13")) {
                			dataRecord.setReqType("施設紐付け削除");
                		}else if(entiry.getReqType().equals("21")) {
                			dataRecord.setReqType("施設来期用項目更新");
                		}else if(entiry.getReqType().equals("31")) {
                			dataRecord.setReqType("医師新規作成");
                		}else if(entiry.getReqType().equals("32")) {
                			dataRecord.setReqType("医師情報更新");
                		}else if(entiry.getReqType().equals("33")) {
                			dataRecord.setReqType("医師削除");
                		}else if(entiry.getReqType().equals("34")) {
                			dataRecord.setReqType("医師復活");
                		}else if(entiry.getReqType().equals("41")) {
                			dataRecord.setReqType("医師勤務先追加");
                		}else if(entiry.getReqType().equals("42")) {
                			dataRecord.setReqType("医療機関への異動");
                		}else if(entiry.getReqType().equals("43")) {
                			dataRecord.setReqType("医療機関以外への異動");
                		}else if(entiry.getReqType().equals("44")) {
                			dataRecord.setReqType("医師勤務先削除");
                		}else if(entiry.getReqType().equals("51")) {
                			dataRecord.setReqType("勤務先情報更新");
                		}else {
                			dataRecord.setReqType(" ");
                		}
                	}else {
                		dataRecord.setReqSts(" ");
                	}

                    // 申請ステータス
//                	if(entiry.getReqSts() != null) {
//                	dataRecord.setReqSts(entiry.getReqSts());
//                	}else {
//                		dataRecord.setReqSts(" ");
//                	}
                	// 申請ステータス
                	if(entiry.getReqSts() != null) {
                		if(entiry.getReqSts().equals("01")) {
                			dataRecord.setReqSts("保存済み");
                		}else if(entiry.getReqSts().equals("02")) {
                			dataRecord.setReqSts("却下済み");
                		}else if(entiry.getReqSts().equals("03")) {
                			dataRecord.setReqSts("承認待ち");
                		}else if(entiry.getReqSts().equals("04")) {
                			dataRecord.setReqSts("承認済み");
                		}else if(entiry.getReqSts().equals("11")) {
                			dataRecord.setReqSts("ULT申請待ち");
                		}else if(entiry.getReqSts().equals("12")) {
                			dataRecord.setReqSts("ULT却下済み");
                		}else if(entiry.getReqSts().equals("13")) {
                			dataRecord.setReqSts("ULT承認待ち");
                		}else if(entiry.getReqSts().equals("14")) {
                			dataRecord.setReqSts("ULT承認済み");
                		}else if(entiry.getReqSts().equals("21")) {
                			dataRecord.setReqSts("FB適用承認済み");
                		}else if(entiry.getReqSts().equals("22")) {
                			dataRecord.setReqSts("FB結果確認");
                		}else if(entiry.getReqSts().equals("31")) {
                			dataRecord.setReqSts("MDM処理中");
                		}else if(entiry.getReqSts().equals("32")) {
                			dataRecord.setReqSts("MDM適用保留");
                		}else if(entiry.getReqSts().equals("33")) {
                			dataRecord.setReqSts("MDM登録済み");
                		}else if(entiry.getReqSts().equals("34")) {
                			dataRecord.setReqSts("MDM却下");
                		}else {
                    		dataRecord.setReqType(" ");
                    	}
                	}

                    // 施設固定コード/医師固定コード
                	if(entiry.getInsNo() != null) {
                	dataRecord.setInsNo(entiry.getInsNo());
                	}else if(entiry.getDocNo() != null){
                		dataRecord.setInsNo(entiry.getDocNo());
                	}else {
                		dataRecord.setInsNo(" ");
                	}
                       //dataRecord.setInsNo(entiry.getInsNo());
                    // 施設名/医師名
                   	if(entiry.getInsFormalName() != null) {
                    	dataRecord.setInsFormalName(entiry.getInsFormalName());
                    	}else if(entiry.getDocKanj() != null){
                    		dataRecord.setInsFormalName(entiry.getDocKanj());
                    	}else {
                    		dataRecord.setInsFormalName(" ");
                    	}

                       //dataRecord.setInsFormalName(entiry.getInsFormalName());
                    // 申請者名
                   	if(entiry.getReqJgiName() != null) {
                    	dataRecord.setReqJgiName(entiry.getReqJgiName());
                    	}else {
                    		dataRecord.setReqJgiName(" ");
                    	}
                       //dataRecord.setReqJgiName(entiry.getReqJgiName());
                    // 申請者所属
                   	if(entiry.getReqShz() != null) {
                    	dataRecord.setReqShz(entiry.getReqShz());
                    	}else {
                    		dataRecord.setReqShz(" ");
                    	}
                   	// dataRecord.setReqShz(entiry.getReqShz());
                    // 申請者コメント
                   	if(entiry.getReqComment() != null) {
                    	dataRecord.setReqComment(entiry.getReqComment());
                    	}else {
                    		dataRecord.setReqComment(" ");
                    	}

                    // 承認日時
                   	if(entiry.getAPR_YMDHMS() != null) {
                        if(entiry.getAPR_YMDHMS().length() == 8) {
                        	dataRecord.setAPR_YMDHMS(entiry.getAPR_YMDHMS().substring(0, 4)+ '/' + entiry.getAPR_YMDHMS().substring(4, 6)+ '/' + entiry.getAPR_YMDHMS().substring(6, 8));
                        }else if(entiry.getAPR_YMDHMS().length() == 12) {
                        	dataRecord.setAPR_YMDHMS(entiry.getAPR_YMDHMS().substring(0, 4)+ '/' + entiry.getAPR_YMDHMS().substring(4, 6)+ '/' + entiry.getAPR_YMDHMS().substring(6, 8)+ ' ' + entiry.getAPR_YMDHMS().substring(8, 10)+ ':' + entiry.getAPR_YMDHMS().substring(10, 12));
                        }else if(entiry.getAPR_YMDHMS().length() == 14) {
                        	dataRecord.setAPR_YMDHMS(entiry.getAPR_YMDHMS().substring(0, 4)+ '/' + entiry.getAPR_YMDHMS().substring(4, 6)+ '/' + entiry.getAPR_YMDHMS().substring(6, 8)+ ' ' + entiry.getAPR_YMDHMS().substring(8, 10)+ ':' + entiry.getAPR_YMDHMS().substring(10, 12)+ ':' + entiry.getAPR_YMDHMS().substring(12, 14));
                        }
                    	//dataRecord.setAPR_YMDHMS(entiry.getAPR_YMDHMS());
                    	}else {
                    		dataRecord.setAPR_YMDHMS(" ");
                    	}
                       //dataRecord.setAPR_YMDHMS(entiry.getAPR_YMDHMS());
                    // 承認者
                   	if(entiry.getAPR_SHA_ID() != null) {
                    	dataRecord.setAPR_SHA_ID(entiry.getAPR_SHA_ID());
                    	}else {
                    		dataRecord.setAPR_SHA_ID(" ");
                    	}
                     //  dataRecord.setAPR_SHA_ID(entiry.getAPR_SHA_ID());
                    // 審査・承認メモ
                   	if(entiry.getAPR_MEMO() != null) {
                    	dataRecord.setAPR_MEMO(entiry.getAPR_MEMO());
                    	}else {
                    		dataRecord.setAPR_MEMO(" ");
                    	}
                       //dataRecord.setAPR_MEMO(entiry.getAPR_MEMO());
                    // 承認・却下コメント
                   	if(entiry.getAprComment() != null) {
                    	dataRecord.setAprComment(entiry.getAprComment());
                    	}else {
                    		dataRecord.setAprComment(" ");
                    	}
                      // dataRecord.setAPR_COMMNET(entiry.getAPR_COMMNET());
                    // 審査
                   	if(entiry.getShnFlg() != null) {
                		if(entiry.getShnFlg().equals("0")) {
                			dataRecord.setShnFlg("未");
                		}else if(entiry.getShnFlg().equals("1")) {
                			dataRecord.setShnFlg("済");
                		}else {
                			dataRecord.setShnFlg(" ");
                		}
                	}else {
                    		dataRecord.setShnFlg(" ");
                    	}
                      // dataRecord.setAPR_COMMNET(entiry.getAPR_COMMNET());
                    // 審査日時
                   	if(entiry.getShnYmdhms() != null) {
                        if(entiry.getShnYmdhms().length() == 8) {
                        	dataRecord.setShnYmdhms(entiry.getShnYmdhms().substring(0, 4)+ '/' + entiry.getShnYmdhms().substring(4, 6)+ '/' + entiry.getShnYmdhms().substring(6, 8));
                        }else if(entiry.getShnYmdhms().length() == 12) {
                        	dataRecord.setShnYmdhms(entiry.getShnYmdhms().substring(0, 4)+ '/' + entiry.getShnYmdhms().substring(4, 6)+ '/' + entiry.getShnYmdhms().substring(6, 8)+ ' ' + entiry.getShnYmdhms().substring(8, 10)+ ':' + entiry.getShnYmdhms().substring(10, 12));
                        }else if(entiry.getShnYmdhms().length() == 14) {
                        	dataRecord.setShnYmdhms(entiry.getShnYmdhms().substring(0, 4)+ '/' + entiry.getShnYmdhms().substring(4, 6)+ '/' + entiry.getShnYmdhms().substring(6, 8)+ ' ' + entiry.getShnYmdhms().substring(8, 10)+ ':' + entiry.getShnYmdhms().substring(10, 12)+ ':' + entiry.getShnYmdhms().substring(12, 14));
                        }
                    	//dataRecord.setShnYmdhms(entiry.getShnYmdhms());
                    	}else {
                    		dataRecord.setShnYmdhms(" ");
                    	}
                      // dataRecord.setAPR_COMMNET(entiry.getAPR_COMMNET());
                    // 審査者
                   	if(entiry.getShnShaId() != null) {
                    	dataRecord.setShnShaId(entiry.getShnShaId());
                    	}else {
                    		dataRecord.setShnShaId(" ");
                    	}
                      // dataRecord.setAPR_COMMNET(entiry.getAPR_COMMNET());

                    // FB申請要否
                   	if(entiry.getFbReqFlg() != null) {
                    	dataRecord.setFbReqFlg(entiry.getFbReqFlg());
                    	}else {
                    		dataRecord.setFbReqFlg(" ");
                    	}
                      // dataRecord.setAPR_COMMNET(entiry.getAPR_COMMNET());

                    // FB回答
                   	if(entiry.getFbAnsId() == null) {
                   		dataRecord.setFbAnsId(" ");
                   	}else if(entiry.getFbAnsId().equals("")) {
                   		dataRecord.setFbAnsId(" ");
                   	}else if(entiry.getFbAnsId() != null) {
                    	dataRecord.setFbAnsId("済");
                    	}
                   	//dataRecord.setFbAnsId(entiry.getFbAnsId());
                      // dataRecord.setAPR_COMMNET(entiry.getAPR_COMMNET());

                    // FB処理区分
                   	if(entiry.getFbPrcType() != null) {
                    	dataRecord.setFbPrcType(entiry.getFbPrcType());
                    	}else {
                    		dataRecord.setFbPrcType(" ");
                    	}
                      // dataRecord.setAPR_COMMNET(entiry.getAPR_COMMNET());

                       catSnseiComboDataList.add(dataRecord);
               }
            //  }
              Boolean check = false;
          //indto.setParamInsNo(paramEntity.getInInsNo());
          //indto.setInsAbbrName("東北大学病院");
          //検索された帳票一覧をDTOに設定する
              if(catSnseiComboDataList.size()>1000) {
            	  check = true;
              }
              if(check == true) {
            	  System.out.print("1000件エラー");
              }


          indto.setCatSnseiComboDataList(catSnseiComboDataList);

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
