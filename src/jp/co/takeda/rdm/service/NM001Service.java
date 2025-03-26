/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import jp.co.takeda.rdm.common.BaseDTO;
import jp.co.takeda.rdm.common.BaseInfoHolder;
import jp.co.takeda.rdm.common.BaseService;
import jp.co.takeda.rdm.common.LoginInfo;
import jp.co.takeda.rdm.dto.CatSnseiComboDataList;
import jp.co.takeda.rdm.dto.NM001DTO;
import jp.co.takeda.rdm.entity.SRdmReqSamariEntity;

import jp.co.takeda.rdm.entity.join.SelectCntSelectReqListEntity;
import jp.co.takeda.rdm.entity.join.SelectHenkanListEntity;
import jp.co.takeda.rdm.entity.join.SelectParamNM001Entity;
import jp.co.takeda.rdm.util.StringUtils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 * Serviceクラス（NM001)
 * @generated
 */
@Named
public class NM001Service extends BaseService {

    /**
     * ログインスタンス
     * @generated
     */
    private static Log log = LogFactory.getLog(NM001Service.class);



    /**
     * イベント処理
     * @param indto ND001DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO sort(NM001DTO indto) throws ParseException{
        BaseDTO outdto = indto;
        // START UOC

        outdto = search(indto);

        // END UOC
        return outdto;
    }

    /**
     * イベント処理
     * @param indto RDMNM001DTO
     * @return 遷移先DTO
     * @customizable
     *  @throws ParseException
     */
    @Transactional
    public BaseDTO init(NM001DTO indto) throws ParseException{
    	LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();

        indto.setPreScreenId(loginInfo.getPreScreenId());
        BaseDTO outdto = indto;
        // START UOC

        // ページ数(現在:１ページ目から)
        indto.setPageCntCur(1);
        indto.setPageFlag("1");
        outdto = search(indto);
        // END UOC
        return outdto;

    }

	public BaseDTO search(NM001DTO indto) throws ParseException{
		BaseDTO outdto = indto;
		SRdmReqSamariEntity paramEntity = new SRdmReqSamariEntity();
      //  List<NM001Entity> selectTestEntity = dao.select(paramEntity);
      //  indto.setTest(selectTestEntity.get(0).getTest());

        //paramEntity.setScreenId("RDMNM001");
        List<NM001DTO> nm001Dto = new ArrayList<NM001DTO>();


          //アドミンflagの検索値のセット、setEmptyToNullで空文字をNullに置換している。
          paramEntity.setMrAdminFlg(StringUtils.setEmptyToNull(indto.getMrAdminFlg()));

          //アドミンflagの検索値のセット、setEmptyToNullで空文字をNullに置換している。
          paramEntity.setJgiNo(StringUtils.setEmptyToNull(indto.getJgiNo()));



          //申請日前部分の検索値のセット、setEmptyToNullで空文字をNullに置換している。
          paramEntity.setReqYmdhmsFrom(StringUtils.setEmptyToNull(indto.getReqYmdhmsFrom()));

          //申請日前部分の検索値のセット、setEmptyToNullで空文字をNullに置換している。
          paramEntity.setReqYmdhmsTo(StringUtils.setEmptyToNull(indto.getReqYmdhmsTo()));


        //SimpleDateFormatで日付フォーマット設定
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
          //日付チェック 開始日が終了日より後の場合
          if (indto.getReqYmdhmsFrom() != null){
              try {
      			if (sdf.parse(indto.getReqYmdhmsFrom()).compareTo(sdf.parse(indto.getReqYmdhmsTo())) == 1) {
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
          if(paramEntity.getReqYmdhmsFrom() != null) {
        	  indto.setInreqYmdhmsFrom(paramEntity.getReqYmdhmsFrom());
              	 //値がある場合：ハイフン除去
              	SelectHenkanListEntity haihunjokyo = new SelectHenkanListEntity("ハイフン除去");
              	haihunjokyo.setSearchHenkan(indto.getReqYmdhmsFrom());
                  //ハイフン除去結果を格納
                  List<SelectHenkanListEntity> selectKnazi = dao.select(haihunjokyo);
                  for (SelectHenkanListEntity haijokyo : selectKnazi) {
                	paramEntity.setReqYmdhmsFrom(haijokyo.getSearchHenkan());
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
                  }
              }


          //入力_検索文字列  施設名がnullでないかのチェック。

          //paramEntity.setInLimit(selectParamNM001List.get(1).getValue());
              //画面初期表示時の帳票一覧を取得する
              List<SRdmReqSamariEntity> deptListEntity = dao.select(paramEntity);

             // for(int i = 0;i < 11; i++) {
              	 for (SRdmReqSamariEntity entiry : deptListEntity) {
              		NM001DTO dataRecord = new NM001DTO();

                	// 都道府県名　
                	if(StringUtils.nvl(entiry.getAddrNamePref(), null) != null) {
                	   dataRecord.setAddrNamePref(entiry.getAddrNamePref());
                	   dataRecord.setAddrCodePref(entiry.getAddrCodePref());
                	}else {
                		dataRecord.setAddrNamePref(" ");
                		dataRecord.setAddrCodePref(" ");
                	}
                	// キー　
                	if(StringUtils.nvl(entiry.getKey(), null) != null) {
                	   dataRecord.setKey(entiry.getKey());
                	}else {
                		dataRecord.setKey(" ");
                	}
              		//データ判定後の数値取得処理
              		if(entiry.getKey().equals("R01")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		dataRecord.setReqCountSsAd(entiry.getReqCount());
                    		dataRecord.setReqType1(entiry.getReqType());
                    		dataRecord.setReqChl1(entiry.getReqChl());
                    		dataRecord.setReqSts1(entiry.getReqSts());
                     	}else {
                     		dataRecord.setReqCountSsAd(" ");
                     		dataRecord.setReqType1(" ");
                    		dataRecord.setReqChl1(" ");
                    		dataRecord.setReqSts1(" ");
                     	}
              		}
              		else if(entiry.getKey().equals("R02")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		dataRecord.setReqCountSsMr(entiry.getReqCount());
                    		dataRecord.setReqType2(entiry.getReqType());
                    		dataRecord.setReqChl2(entiry.getReqChl());
                    		dataRecord.setReqSts2(entiry.getReqSts());
                     	}else {
                     		dataRecord.setReqCountSsMr(" ");
                     		dataRecord.setReqType2(" ");
                     		dataRecord.setReqChl2(" ");
                     		dataRecord.setReqSts2(" ");
                     	}
              		}
              		else if(entiry.getKey().equals("R03")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		 dataRecord.setReqCountSsUr(entiry.getReqCount());
                    		 dataRecord.setReqType3(entiry.getReqType());
                    		 dataRecord.setReqChl3(entiry.getReqChl());
                    		 dataRecord.setReqSts3(entiry.getReqSts());
                     	}else {
                     		dataRecord.setReqCountSsUr(" ");
                     		dataRecord.setReqType3(" ");
                     		dataRecord.setReqChl3(" ");
                     		dataRecord.setReqSts3(" ");
                     	}
              		}
              		else if(entiry.getKey().equals("R04")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		dataRecord.setReqCountSsUs(entiry.getReqCount());
                    		dataRecord.setReqType4(entiry.getReqType());
                    		dataRecord.setReqChl4(entiry.getReqChl());
                    		dataRecord.setReqSts4(entiry.getReqSts());
                     	}else {
                     		dataRecord.setReqCountSsUs(" ");
                     		dataRecord.setReqType4(" ");
                     		dataRecord.setReqChl4(" ");
                     		dataRecord.setReqSts4(" ");
                     	}
              		}
              		else if(entiry.getKey().equals("R05")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		dataRecord.setReqCountScAd(entiry.getReqCount());
                    		dataRecord.setReqType5(entiry.getReqType());
                    		dataRecord.setReqChl5(entiry.getReqChl());
                    		dataRecord.setReqSts5(entiry.getReqSts());
                     	}else {
                     		dataRecord.setReqCountScAd(" ");
                     		dataRecord.setReqType5(" ");
                     		dataRecord.setReqChl5(" ");
                     		dataRecord.setReqSts5(" ");
                     	}

              		}
              		else if(entiry.getKey().equals("R06")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		 dataRecord.setReqCountScMr(entiry.getReqCount());
                    		 dataRecord.setReqType6(entiry.getReqType());
                    		 dataRecord.setReqChl6(entiry.getReqChl());
                    		 dataRecord.setReqSts6(entiry.getReqSts());

                     	}else {
                     		dataRecord.setReqCountScMr(" ");
                     		dataRecord.setReqType6(" ");
                     		dataRecord.setReqChl6(" ");
                     		dataRecord.setReqSts6(" ");
                     	}

              		}
              		else if(entiry.getKey().equals("R07")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		dataRecord.setReqCountScUr(entiry.getReqCount());
                    		dataRecord.setReqType7(entiry.getReqType());
                    		dataRecord.setReqChl7(entiry.getReqChl());
                    		dataRecord.setReqSts7(entiry.getReqSts());
                     	}else {
                     		dataRecord.setReqCountScUr(" ");
                     		dataRecord.setReqType7(" ");
                     		dataRecord.setReqChl7(" ");
                     		dataRecord.setReqSts7(" ");
                     	}

              		}
              		else if(entiry.getKey().equals("R08")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		 dataRecord.setReqCountScUs(entiry.getReqCount());
                    		 dataRecord.setReqType8(entiry.getReqType());
                    		 dataRecord.setReqChl8(entiry.getReqChl());
                    		 dataRecord.setReqSts8(entiry.getReqSts());
                     	}else {
                     		dataRecord.setReqCountScUs(" ");
                     		dataRecord.setReqType8(" ");
                     		dataRecord.setReqChl8(" ");
                     		dataRecord.setReqSts8(" ");
                     	}

              		}
              		else if(entiry.getKey().equals("R09")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		dataRecord.setReqCountSdAd(entiry.getReqCount());
                			dataRecord.setReqType9(entiry.getReqType());
                    		dataRecord.setReqChl9(entiry.getReqChl());
                    		dataRecord.setReqSts9(entiry.getReqSts());
                     	}else {
                     		dataRecord.setReqCountSdAd(" ");
                     		dataRecord.setReqType9(" ");
                     		dataRecord.setReqChl9(" ");
                     		dataRecord.setReqSts9(" ");
                     	}

              		}
              		else if(entiry.getKey().equals("R10")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		dataRecord.setReqCountSdMr(entiry.getReqCount());
                    		dataRecord.setReqType10(entiry.getReqType());
                    		dataRecord.setReqChl10(entiry.getReqChl());
                    		dataRecord.setReqSts10(entiry.getReqSts());
                     	}else {
                     		dataRecord.setReqCountSdMr(" ");
                     		dataRecord.setReqType10(" ");
                     		dataRecord.setReqChl10(" ");
                     		dataRecord.setReqSts10(" ");
                     	}

              		}
              		else if(entiry.getKey().equals("R11")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		dataRecord.setReqCountSdUr(entiry.getReqCount());
                    		dataRecord.setReqType11(entiry.getReqType());
                    		dataRecord.setReqChl11(entiry.getReqChl());
                    		dataRecord.setReqSts11(entiry.getReqSts());
                     	}else {
                     		dataRecord.setReqCountSdUr(" ");
                     		dataRecord.setReqType11(" ");
                     		dataRecord.setReqChl11(" ");
                     		dataRecord.setReqSts11(" ");
                     	}

              		}
              		else if(entiry.getKey().equals("R12")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		dataRecord.setReqCountSdUs(entiry.getReqCount());
                    		dataRecord.setReqType12(entiry.getReqType());
                    		dataRecord.setReqChl12(entiry.getReqChl());
                    		dataRecord.setReqSts12(entiry.getReqSts());
                     	}else {
                     		dataRecord.setReqCountSdUs(" ");
                     		dataRecord.setReqType12(" ");
                     		dataRecord.setReqChl12(" ");
                     		dataRecord.setReqSts12(" ");
                     	}

              		}
              		else if(entiry.getKey().equals("R13")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		dataRecord.setReqCountRnAd(entiry.getReqCount());
                    		dataRecord.setReqType13(entiry.getReqType());
                    		dataRecord.setReqChl13(entiry.getReqChl());
                    		dataRecord.setReqSts13(entiry.getReqSts());
                     	}else {
                     		dataRecord.setReqCountRnAd(" ");
                     		dataRecord.setReqType13(" ");
                     		dataRecord.setReqChl13(" ");
                     		dataRecord.setReqSts13(" ");
                     	}

              		}
              		else if(entiry.getKey().equals("R14")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		dataRecord.setReqCountRnMr(entiry.getReqCount());
                    		dataRecord.setReqType14(entiry.getReqType());
                    		dataRecord.setReqChl14(entiry.getReqChl());
                    		dataRecord.setReqSts14(entiry.getReqSts());
                     	}else {
                     		dataRecord.setReqCountRnMr(" ");
                     		dataRecord.setReqType14(" ");
                     		dataRecord.setReqChl14(" ");
                     		dataRecord.setReqSts14(" ");
                     	}

              		}
              		else if(entiry.getKey().equals("R15")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		dataRecord.setReqCountTsAd(entiry.getReqCount());
                    		dataRecord.setReqType33(entiry.getReqType());
                    		dataRecord.setReqChl33(entiry.getReqChl());
                    		dataRecord.setReqSts33(entiry.getReqSts());
                     	}else {
                     		dataRecord.setReqCountTsAd(" ");
                     		dataRecord.setReqType33(" ");
                     		dataRecord.setReqChl33(" ");
                     		dataRecord.setReqSts33(" ");
                     	}

              		}
              		else if(entiry.getKey().equals("R16")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		   dataRecord.setReqCountTsMr(entiry.getReqCount());
                    		   dataRecord.setReqType34(entiry.getReqType());
                    		   dataRecord.setReqChl34(entiry.getReqChl());
                    		   dataRecord.setReqSts34(entiry.getReqSts());
                     	}else {
                     		dataRecord.setReqCountTsMr(" ");
                     		dataRecord.setReqType34(" ");
                     		dataRecord.setReqChl34(" ");
                     		dataRecord.setReqSts34(" ");
                     	}

              		}
              		else if(entiry.getKey().equals("R17")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		 dataRecord.setReqCountSdAd(entiry.getReqCount());
                    		 dataRecord.setReqType9(entiry.getReqType());
                    		 dataRecord.setReqChl9(entiry.getReqChl());
                    		 dataRecord.setReqSts9(entiry.getReqSts());
                     	}else {
                     		dataRecord.setReqCountSdAd(" ");
                     		dataRecord.setReqType9(" ");
                     		dataRecord.setReqChl9(" ");
                     		dataRecord.setReqSts9(" ");
                     	}

              		}
              		else if(entiry.getKey().equals("R18")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		dataRecord.setReqCountSdMr(entiry.getReqCount());
                    		dataRecord.setReqType10(entiry.getReqType());
                    		dataRecord.setReqChl10(entiry.getReqChl());
                    		dataRecord.setReqSts10(entiry.getReqSts());
                     	}else {
                     		dataRecord.setReqCountSdMr(" ");
                     		dataRecord.setReqType10(" ");
                     		dataRecord.setReqChl10(" ");
                     		dataRecord.setReqSts10(" ");
                     	}

              		}
              		else if(entiry.getKey().equals("R19")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		 dataRecord.setReqCountSdUr(entiry.getReqCount());
                    		 dataRecord.setReqType11(entiry.getReqType());
                    		 dataRecord.setReqChl11(entiry.getReqChl());
                    		 dataRecord.setReqSts11(entiry.getReqSts());
                     	}else {
                     		dataRecord.setReqCountSdUr(" ");
                     		dataRecord.setReqType11(" ");
                     		dataRecord.setReqChl11(" ");
                     		dataRecord.setReqSts11(" ");
                     	}

              		}
              		else if(entiry.getKey().equals("R20")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		dataRecord.setReqCountSsAd(entiry.getReqCount());
                    		dataRecord.setReqType12(entiry.getReqType());
                    		dataRecord.setReqChl12(entiry.getReqChl());
                    		dataRecord.setReqSts12(entiry.getReqSts());
                     	}else {
                     		dataRecord.setReqCountSsAd(" ");
                     		dataRecord.setReqType12(" ");
                     		dataRecord.setReqChl12(" ");
                     		dataRecord.setReqSts12(" ");
                     	}

              		}
              		else if(entiry.getKey().equals("R21")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		 dataRecord.setReqCountShAd(entiry.getReqCount());
                    		 dataRecord.setReqType15(entiry.getReqType());
                    		 dataRecord.setReqChl15(entiry.getReqChl());
                    		 dataRecord.setReqSts15(entiry.getReqSts());
                     	}else {
                     		dataRecord.setReqCountShAd(" ");
                     		dataRecord.setReqType15(" ");
                     		dataRecord.setReqChl15(" ");
                     		dataRecord.setReqSts15(" ");
                     	}

              		}
              		else if(entiry.getKey().equals("R22")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		dataRecord.setReqCountShMr(entiry.getReqCount());
                    		dataRecord.setReqType16(entiry.getReqType());
                    		dataRecord.setReqChl16(entiry.getReqChl());
                    		dataRecord.setReqSts16(entiry.getReqSts());
                     	}else {
                     		dataRecord.setReqCountShMr(" ");
                     		dataRecord.setReqType16(" ");
                     		dataRecord.setReqChl16(" ");
                     		dataRecord.setReqSts16(" ");
                     	}

              		}
              		else if(entiry.getKey().equals("R23")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		dataRecord.setReqCountDsAd(entiry.getReqCount());
                    		dataRecord.setReqType17(entiry.getReqType());
                    		dataRecord.setReqChl17(entiry.getReqChl());
                    		dataRecord.setReqSts17(entiry.getReqSts());
                     	}else {
                     		dataRecord.setReqCountDsAd(" ");
                     		dataRecord.setReqType17(" ");
                     		dataRecord.setReqChl17(" ");
                     		dataRecord.setReqSts17(" ");
                     	}

              		}
              		else if(entiry.getKey().equals("R24")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		dataRecord.setReqCountDsMr(entiry.getReqCount());
                    		dataRecord.setReqType18(entiry.getReqType());
                    		dataRecord.setReqChl18(entiry.getReqChl());
                    		dataRecord.setReqSts18(entiry.getReqSts());
                     	}else {
                     		dataRecord.setReqCountDsMr(" ");
                     		dataRecord.setReqType18(" ");
                     		dataRecord.setReqChl18(" ");
                     		dataRecord.setReqSts18(" ");
                     	}

              		}
              		else if(entiry.getKey().equals("R25")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		 dataRecord.setReqCountDsUr(entiry.getReqCount());
                    		 dataRecord.setReqType19(entiry.getReqType());
                    		 dataRecord.setReqChl19(entiry.getReqChl());
                    		 dataRecord.setReqSts19(entiry.getReqSts());
                     	}else {
                     		dataRecord.setReqCountDsUr(" ");
                     		dataRecord.setReqType19(" ");
                     		dataRecord.setReqChl19(" ");
                     		dataRecord.setReqSts19(" ");
                     	}

              		}
              		else if(entiry.getKey().equals("R26")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		 dataRecord.setReqCountDsUs(entiry.getReqCount());
                    		 dataRecord.setReqType20(entiry.getReqType());
                    		 dataRecord.setReqChl20(entiry.getReqChl());
                    		 dataRecord.setReqSts20(entiry.getReqSts());
                     	}else {
                     		dataRecord.setReqCountDsUs(" ");
                     		dataRecord.setReqType20(" ");
                     		dataRecord.setReqChl20(" ");
                     		dataRecord.setReqSts20(" ");
                     	}

              		}
              		else if(entiry.getKey().equals("R27")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		 dataRecord.setReqCountDhAd(entiry.getReqCount());
                    		 dataRecord.setReqType25(entiry.getReqType());
                    		 dataRecord.setReqChl25(entiry.getReqChl());
                    		 dataRecord.setReqSts25(entiry.getReqSts());
                     	}else {
                     		dataRecord.setReqCountDhAd(" ");
                     		dataRecord.setReqType25(" ");
                     		dataRecord.setReqChl25(" ");
                     		dataRecord.setReqSts25(" ");
                     	}

              		}
              		else if(entiry.getKey().equals("R28")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		dataRecord.setReqCountDhMr(entiry.getReqCount());
                    		dataRecord.setReqType26(entiry.getReqType());
                    		dataRecord.setReqChl26(entiry.getReqChl());
                    		dataRecord.setReqSts26(entiry.getReqSts());
                     	}else {
                     		dataRecord.setReqCountDhMr(" ");
                     		dataRecord.setReqType26(" ");
                     		dataRecord.setReqChl26(" ");
                     		dataRecord.setReqSts26(" ");
                     	}

              		}
              		else if(entiry.getKey().equals("R29")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		dataRecord.setReqCountDhUr(entiry.getReqCount());
                    		dataRecord.setReqType27(entiry.getReqType());
                    		dataRecord.setReqChl27(entiry.getReqChl());
                    		dataRecord.setReqSts27(entiry.getReqSts());
                     	}else {
                     		dataRecord.setReqCountDhUr(" ");
                     		dataRecord.setReqType27(" ");
                     		dataRecord.setReqChl27(" ");
                     		dataRecord.setReqSts27(" ");
                     	}
              		}
              		else if(entiry.getKey().equals("R30")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		dataRecord.setReqCountDhUs(entiry.getReqCount());
                    		dataRecord.setReqType28(entiry.getReqType());
                    		dataRecord.setReqChl28(entiry.getReqChl());
                    		dataRecord.setReqSts28(entiry.getReqSts());
                     	}else {
                     		dataRecord.setReqCountDhUs(" ");
                     		dataRecord.setReqType28(" ");
                     		dataRecord.setReqChl28(" ");
                     		dataRecord.setReqSts28(" ");
                     	}

              		}
              		else if(entiry.getKey().equals("R31")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		 dataRecord.setReqCountDdAd(entiry.getReqCount());
                    		 dataRecord.setReqType21(entiry.getReqType());
                    		 dataRecord.setReqChl21(entiry.getReqChl());
                    		 dataRecord.setReqSts21(entiry.getReqSts());
                     	}else {
                     		dataRecord.setReqCountDdAd(" ");
                     		dataRecord.setReqType21(" ");
                     		dataRecord.setReqChl21(" ");
                     		dataRecord.setReqSts21(" ");
                     	}

              		}
              		else if(entiry.getKey().equals("R32")) {
                    	if(!entiry.getReqCount().equals("0")) {
                 	        dataRecord.setReqCountDdMr(entiry.getReqCount());
                 	        dataRecord.setReqType22(entiry.getReqType());
                 	        dataRecord.setReqChl22(entiry.getReqChl());
                 	        dataRecord.setReqSts22(entiry.getReqSts());
                     	}else {
                     		dataRecord.setReqCountDdMr(" ");
                     		dataRecord.setReqType22(" ");
                     		dataRecord.setReqChl22(" ");
                     		dataRecord.setReqSts22(" ");
                     	}
              		}
              		else if(entiry.getKey().equals("R33")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		 dataRecord.setReqCountDdUr(entiry.getReqCount());
                    		 dataRecord.setReqType23(entiry.getReqType());
                    		 dataRecord.setReqChl23(entiry.getReqChl());
                    		 dataRecord.setReqSts23(entiry.getReqSts());
                     	}else {
                     		dataRecord.setReqCountDdUr(" ");
                     		dataRecord.setReqType23(" ");
                     		dataRecord.setReqChl23(" ");
                     		dataRecord.setReqSts23(" ");
                     	}
              		}
              		else if(entiry.getKey().equals("R34")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		dataRecord.setReqCountDdUs(entiry.getReqCount());
                    		dataRecord.setReqType24(entiry.getReqType());
                    		dataRecord.setReqChl24(entiry.getReqChl());
                    		dataRecord.setReqSts24(entiry.getReqSts());
                     	}else {
                     		dataRecord.setReqCountDdUs(" ");
                     		dataRecord.setReqType24(" ");
                     		dataRecord.setReqChl24(" ");
                     		dataRecord.setReqSts24(" ");
                     	}
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

                	// 申請区分　コードの値を文字に変換している
                	if(entiry.getReqType() != null) {
                	dataRecord.setReqType(entiry.getReqType());
                	}else {
                		dataRecord.setReqType(" ");
                	}
                    // 申請ステータス
                	if(entiry.getReqSts() != null) {
                	dataRecord.setReqSts(entiry.getReqSts());
                	}else {
                		dataRecord.setReqSts(" ");
                	}
                	//申請チャネル
                	if(entiry.getReqChl() != null) {
                	dataRecord.setReqChl(entiry.getReqChl());
                	}else {
                		dataRecord.setReqChl(" ");
                	}
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

                	nm001Dto.add(dataRecord);

               }
            //  }

          //indto.setParamInsNo(paramEntity.getInInsNo());
          //indto.setInsAbbrName("東北大学病院");
          //検索された帳票一覧をDTOに設定する

          indto.setPageFlag("0");
          indto.setNM001DTO(nm001Dto);


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
    public BaseDTO page(NM001DTO indto) throws ParseException {
        BaseDTO outdto = indto;
        // START UOC

        outdto = search(indto);

        // END UOC
        return outdto;
    }
}
