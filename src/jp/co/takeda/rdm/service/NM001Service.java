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
import jp.co.takeda.rdm.common.BaseService;
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
        BaseDTO outdto = indto;
        // START UOC

        // ページ数(現在:１ページ目から)
        indto.setPageCntCur(1);
        indto.setPageFlag("1");

        // END UOC
        return outdto;

    }

	public BaseDTO search(NM001DTO indto) throws ParseException{
		BaseDTO outdto = indto;
		SRdmReqSamariEntity paramEntity = new SRdmReqSamariEntity();
      //  List<NM001Entity> selectTestEntity = dao.select(paramEntity);
      //  indto.setTest(selectTestEntity.get(0).getTest());
		indto.setPageFlag("0");


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
                	}else {
                		dataRecord.setAddrNamePref(" ");
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
                     	}else {
                     		dataRecord.setReqCountSsAd(" ");
                     	}
              		}
              		else if(entiry.getKey().equals("R02")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		dataRecord.setReqCountSsMr(entiry.getReqCount());
                     	}else {
                     		dataRecord.setReqCountSsMr(" ");
                     	}
              		}
              		else if(entiry.getKey().equals("R03")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		 dataRecord.setReqCountSsUr(entiry.getReqCount());
                     	}else {
                     		dataRecord.setReqCountSsUr(" ");
                     	}
              		}
              		else if(entiry.getKey().equals("R04")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		dataRecord.setReqCountSsUs(entiry.getReqCount());
                     	}else {
                     		dataRecord.setReqCountSsUs(" ");
                     	}
              		}
              		else if(entiry.getKey().equals("R05")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		dataRecord.setReqCountScAd(entiry.getReqCount());
                     	}else {
                     		dataRecord.setReqCountScAd(" ");
                     	}

              		}
              		else if(entiry.getKey().equals("R06")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		 dataRecord.setReqCountScMr(entiry.getReqCount());
                     	}else {
                     		dataRecord.setReqCountScMr(" ");
                     	}

              		}
              		else if(entiry.getKey().equals("R07")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		dataRecord.setReqCountScUr(entiry.getReqCount());
                     	}else {
                     		dataRecord.setReqCountScUr(" ");
                     	}

              		}
              		else if(entiry.getKey().equals("R08")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		 dataRecord.setReqCountScUs(entiry.getReqCount());
                     	}else {
                     		dataRecord.setReqCountScUs(" ");
                     	}

              		}
              		else if(entiry.getKey().equals("R09")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		 dataRecord.setReqCountSdAd(entiry.getReqCount());
                     	}else {
                     		dataRecord.setReqCountSdAd(" ");
                     	}

              		}
              		else if(entiry.getKey().equals("R10")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		dataRecord.setReqCountSdMr(entiry.getReqCount());
                     	}else {
                     		dataRecord.setReqCountSdMr(" ");
                     	}

              		}
              		else if(entiry.getKey().equals("R11")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		dataRecord.setReqCountSdUr(entiry.getReqCount());
                     	}else {
                     		dataRecord.setReqCountSdUr(" ");
                     	}

              		}
              		else if(entiry.getKey().equals("R12")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		dataRecord.setReqCountSsAd(entiry.getReqCount());
                     	}else {
                     		dataRecord.setReqCountSsAd(" ");
                     	}

              		}
              		else if(entiry.getKey().equals("R13")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		dataRecord.setReqCountRnAd(entiry.getReqCount());
                     	}else {
                     		dataRecord.setReqCountRnAd(" ");
                     	}

              		}
              		else if(entiry.getKey().equals("R14")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		dataRecord.setReqCountRnMr(entiry.getReqCount());
                     	}else {
                     		dataRecord.setReqCountRnMr(" ");
                     	}

              		}
              		else if(entiry.getKey().equals("R15")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		dataRecord.setReqCountTsAd(entiry.getReqCount());
                     	}else {
                     		dataRecord.setReqCountTsAd(" ");
                     	}

              		}
              		else if(entiry.getKey().equals("R16")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		   dataRecord.setReqCountTsMr(entiry.getReqCount());
                     	}else {
                     		dataRecord.setReqCountTsMr(" ");
                     	}

              		}
              		else if(entiry.getKey().equals("R17")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		 dataRecord.setReqCountSdAd(entiry.getReqCount());
                     	}else {
                     		dataRecord.setReqCountSdAd(" ");
                     	}

              		}
              		else if(entiry.getKey().equals("R18")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		dataRecord.setReqCountSdMr(entiry.getReqCount());
                     	}else {
                     		dataRecord.setReqCountSdMr(" ");
                     	}

              		}
              		else if(entiry.getKey().equals("R19")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		 dataRecord.setReqCountSdUr(entiry.getReqCount());
                     	}else {
                     		dataRecord.setReqCountSdUr(" ");
                     	}

              		}
              		else if(entiry.getKey().equals("R20")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		dataRecord.setReqCountSsAd(entiry.getReqCount());
                     	}else {
                     		dataRecord.setReqCountSsAd(" ");
                     	}

              		}
              		else if(entiry.getKey().equals("R21")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		 dataRecord.setReqCountShAd(entiry.getReqCount());
                     	}else {
                     		dataRecord.setReqCountShAd(" ");
                     	}

              		}
              		else if(entiry.getKey().equals("R22")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		dataRecord.setReqCountShMr(entiry.getReqCount());
                     	}else {
                     		dataRecord.setReqCountShMr(" ");
                     	}

              		}
              		else if(entiry.getKey().equals("R23")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		dataRecord.setReqCountDsAd(entiry.getReqCount());
                     	}else {
                     		dataRecord.setReqCountDsAd(" ");
                     	}

              		}
              		else if(entiry.getKey().equals("R24")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		dataRecord.setReqCountDsMr(entiry.getReqCount());
                     	}else {
                     		dataRecord.setReqCountDsMr(" ");
                     	}

              		}
              		else if(entiry.getKey().equals("R25")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		 dataRecord.setReqCountDsUr(entiry.getReqCount());
                     	}else {
                     		dataRecord.setReqCountDsUr(" ");
                     	}

              		}
              		else if(entiry.getKey().equals("R26")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		 dataRecord.setReqCountDsUs(entiry.getReqCount());
                     	}else {
                     		dataRecord.setReqCountDsUs(" ");
                     	}

              		}
              		else if(entiry.getKey().equals("R27")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		 dataRecord.setReqCountDhAd(entiry.getReqCount());
                     	}else {
                     		dataRecord.setReqCountDhAd(" ");
                     	}

              		}
              		else if(entiry.getKey().equals("R28")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		dataRecord.setReqCountDhMr(entiry.getReqCount());
                     	}else {
                     		dataRecord.setReqCountDhMr(" ");
                     	}

              		}
              		else if(entiry.getKey().equals("R29")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		dataRecord.setReqCountDhUr(entiry.getReqCount());
                     	}else {
                     		dataRecord.setReqCountDhUr(" ");
                     	}

              		}
              		else if(entiry.getKey().equals("R30")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		dataRecord.setReqCountDhUs(entiry.getReqCount());
                     	}else {
                     		dataRecord.setReqCountDhUs(" ");
                     	}

              		}
              		else if(entiry.getKey().equals("R31")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		 dataRecord.setReqCountDdAd(entiry.getReqCount());
                     	}else {
                     		dataRecord.setReqCountDdAd(" ");
                     	}

              		}
              		else if(entiry.getKey().equals("R32")) {
                    	if(!entiry.getReqCount().equals("0")) {
                 	        dataRecord.setReqCountDdMr(entiry.getReqCount());
                     	}else {
                     		dataRecord.setReqCountDdMr(" ");
                     	}
              		}
              		else if(entiry.getKey().equals("R33")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		 dataRecord.setReqCountDdUr(entiry.getReqCount());
                     	}else {
                     		dataRecord.setReqCountDdUr(" ");
                     	}
              		}
              		else if(entiry.getKey().equals("R34")) {
                    	if(!entiry.getReqCount().equals("0")) {
                    		dataRecord.setReqCountDdUs(entiry.getReqCount());
                     	}else {
                     		dataRecord.setReqCountDdUs(" ");
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
