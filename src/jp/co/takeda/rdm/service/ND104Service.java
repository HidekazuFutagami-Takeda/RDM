/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import jp.co.takeda.rdm.common.BaseDTO;
import jp.co.takeda.rdm.common.BaseInfoHolder;
import jp.co.takeda.rdm.common.BaseService;
import jp.co.takeda.rdm.common.LoginInfo;
import jp.co.takeda.rdm.dto.ND104DTO;
import jp.co.takeda.rdm.entity.MRdmHcpYakusyokuEntity;
import jp.co.takeda.rdm.entity.join.MRdmCodeMstEntity;
import jp.co.takeda.rdm.entity.join.SelectHcpKmuReqDelEntity;
import jp.co.takeda.rdm.entity.join.SeqRdmReqIdEntity;
import jp.co.takeda.rdm.entity.join.TRdmHcpKmuReqEntity;
import jp.co.takeda.rdm.entity.join.TRdmReqKnrEntity;
import jp.co.takeda.rdm.util.DateUtils;
import jp.co.takeda.rdm.util.StringUtils;

/**
 * Serviceクラス（ND104)
 * @generated
 */
@Named
public class ND104Service extends BaseService {

	//ログインユーザ情報取得
    LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();

    boolean errChk = false;
	String msgStr = "";
	String tmpMsgStr = "";
	int len = 0;

    /**
     * イベント処理
     * @param dto NC204DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO initReq(ND104DTO dto) {
        BaseDTO outdto = dto;
        // START UOC

        // ページ数(現在:１ページ目から)
        dto.setPageCntCur(1);

        SelectHcpKmuReqDelEntity paramEntity = new SelectHcpKmuReqDelEntity();

        //申請IDをセット
        paramEntity.setParamReqId(dto.getParamReqId());
        if (StringUtils.isEmpty(dto.getParamReqId())) {
        	dto.setParamReqId("-");
        }
        //医師固定Cをセット
        paramEntity.setParamDocNo(dto.getParamDocNo());

      //申請ステータス_生成用エンティティ
    	MRdmCodeMstEntity paramStatus = new MRdmCodeMstEntity();
    	//検索条件_申請ステータス
    	paramStatus.setCodeName("REQ_STS");
        //申請ステータスの帳票一覧を取得する
        List<MRdmCodeMstEntity> SelectparamStatusList = dao.selectByValue(paramStatus);

        //医師_役職マスタ_生成用エンティティ
 	   	MRdmHcpYakusyokuEntity paramYakusyoku = new MRdmHcpYakusyokuEntity();
 	   	//検索条件_大学職位利用フラグ=0
 	   	paramYakusyoku.setUnivTitleFlg("0");
        //役職の帳票一覧を取得する
        List<MRdmHcpYakusyokuEntity> SelectYakusyoku = dao.select(paramYakusyoku);

        //医師_役職マスタ_生成用エンティティ
        MRdmHcpYakusyokuEntity paramDaigakuSyokui = new MRdmHcpYakusyokuEntity();
        //検索条件_大学職位利用フラグ=0
        paramDaigakuSyokui.setUnivTitleFlg("1");
        //大学職位の帳票一覧を取得する
        List<MRdmHcpYakusyokuEntity> SelectDaigakuSyokui = dao.select(paramDaigakuSyokui);

        //勤務形態_生成用エンティティ
 	   	MRdmCodeMstEntity paramKinmuKeitai = new MRdmCodeMstEntity();
 	   	//検索条件_勤務形態
 	   	paramKinmuKeitai.setCodeName("JOB_FORM");
 	   paramKinmuKeitai.setSqlId("selectByValue");
        //勤務形態の帳票一覧を取得する
        List<MRdmCodeMstEntity> SelectKinmuKeitaiList = dao.select(paramKinmuKeitai);

        //薬審メンバー区分_生成用エンティティ
 	   	MRdmCodeMstEntity paramYakushin = new MRdmCodeMstEntity();
 	   	//検索条件_薬審メンバー区分
 	   	paramYakushin.setCodeName("DCC");
 	   paramYakushin.setSqlId("selectByValue");
        //薬審メンバー区分の帳票一覧を取得する
        List<MRdmCodeMstEntity> SelectYakushinList = dao.select(paramYakushin);

        //画面初期表示時の帳票一覧を取得する
        List<SelectHcpKmuReqDelEntity> SelectHcpKmuReqDelList = dao.select(paramEntity);

        for (SelectHcpKmuReqDelEntity entity : SelectHcpKmuReqDelList) {

        	//申請者所属
        	dto.setReqShz(entity.getReqShz());
        	//申請ステータス(名称)
        	for (MRdmCodeMstEntity outEntity : SelectparamStatusList) {
        		if (Objects.deepEquals(entity.getReqSts(),outEntity.getValue1())) {
        			dto.setReqSts(outEntity.getValue1Kanj());
        			break;
        		}
            }

        	//保存ボタン活性フラグ
        	//'01'(保存済み)、'03'（承認待ち）、'13'(ULT承認待ち)の場合　活性
        	if (Objects.deepEquals(entity.getReqSts(), "01") ||
    			Objects.deepEquals(entity.getReqSts(), "03") ||
    			Objects.deepEquals(entity.getReqSts(), "13")
        			) {

        	}
        	else {//その他非活

        	}
        	if("JKN0813".equals(dto.getLoginJokenSetCd())) {//管理者
        		//'01'(保存済み)、'03'（承認待ち）、'13'(ULT承認待ち)の場合　活性
            	if (Objects.deepEquals(entity.getReqSts(), "01") ||
        			Objects.deepEquals(entity.getReqSts(), "03") ||
        			Objects.deepEquals(entity.getReqSts(), "13")
            			) {
            		dto.getShinseiButtonFlg();
            	}
            	else {//その他非活

            	}
        	}
        	else {

        	}

        	//申請画面　活性フラグ

        	//申請者氏名
        	dto.setJgiName(entity.getJgiName());
        	//申請日時
        	if (!StringUtils.isEmpty(entity.getReqYmdhms())) {
        		String reqYmdhms = entity.getReqYmdhms();
            	String yyyy = reqYmdhms.substring(0,4);
            	String  mm = reqYmdhms.substring(4,6);
            	String  dd = reqYmdhms.substring(6,8);
            	dto.setReqYmdhms(yyyy + "-" + mm + "-" + dd);
        	}

        	//申請者従業員番号
        	dto.setJgiNo(Integer.parseInt(entity.getReqJgiNo()));
        	dto.setBumonRyakuName(entity.getReqShz()); //所属組織名（部門名略式）
        	//申請者所属リージョン
        	dto.setBrCode(entity.getBrCode());
        	//申請者所属エリア
        	dto.setDistCode(entity.getReqDistCode());
        	//申請ステータス(コード)
        	dto.setReqStsCd(entity.getReqStsCd());
        	//更新日
        	dto.setUpdShaYmd(entity.getUpdShaYmd());
        	//氏名（漢字）
        	dto.setDocKanj(entity.getDocKanj());
        	//医師固定コード
        	dto.setDocNo(entity.getDocNo());
        	//ULT医師コード
        	dto.setUrlDocNo(entity.getUrlDocNo());
        	//施設略式漢字名
        	dto.setInsAbbrName(entity.getInsAbbrName());
        	//所属部科漢字名
        	dto.setDeptKj(entity.getDeptKj());

        	//役職コード(異動先)
        	for (MRdmHcpYakusyokuEntity outEntity : SelectYakusyoku) {
        		if (Objects.equals(outEntity.getTitleCode(),entity.getTitleCodeBf())) {
        			dto.setTitleCodeName(outEntity.getTitleKj());
        			break;
        		}
        	}
        	//勤務形態(異動先)
        	for (MRdmCodeMstEntity outEntity : SelectKinmuKeitaiList) {
        		if (Objects.equals(outEntity.getValue1(),entity.getJobFormBf())) {
        			dto.setJobFormBfName(outEntity.getValue1Kanj());
        			break;
        		}
        	}
        	//薬審メンバー区分(異動先)
	         for (MRdmCodeMstEntity outEntity : SelectYakushinList) {
	         	if (Objects.equals(outEntity.getValue1(),entity.getDccTypeBf())) {
	        			dto.setDccTypeBfName(outEntity.getValue1Kanj());
	        			break;
	        		}
	         }
	        	//大学職位コード(異動先)
	         for (MRdmHcpYakusyokuEntity outEntity : SelectDaigakuSyokui) {
	         	if (Objects.equals(outEntity.getTitleCode(),entity.getUnivPosCodeBf())) {
	        			dto.setUnivPosCodeBfName(outEntity.getTitleKj());
	        			break;
	        		}
	         }
        	//適用開始日
        	if (!StringUtils.isEmpty(entity.getTekiyoYmd())) {
        		String tekiyoYmd = entity.getTekiyoYmd();
            	String Tyyyy = tekiyoYmd.substring(0,4);
            	String  Tmm = tekiyoYmd.substring(4,6);
            	String  Tdd = tekiyoYmd.substring(6,8);
            	dto.setTekiyoYmd(Tyyyy + "-" + Tmm + "-" + Tdd);
        	}

        	//施設固定コード(異動元)
        	dto.setInsNoMt(entity.getInsNoMt());
        	//施設固定コード
        	dto.setParamInsNo(entity.getInsNoMt());
        	//ULT施設コード
        	dto.setUltInsNo(entity.getUltInsNo());
        	//所属部科コード(異動元)
        	dto.setDeptCodeBf(entity.getDeptCodeBf());
        	//所属部科カナ名
        	dto.setDeptKn(entity.getDeptKn());
        	//申請コメント
        	dto.setReqComment(entity.getReqComment());
        	//却下コメント
        	dto.setAprComment(entity.getAprComment());
        	//施設分類
        	dto.setInsClass(entity.getInsClass());
        	//対象区分
        	dto.setHoInsType(entity.getHoInsType());

        }

        // END UOC
        return outdto;
    }

    /**
     * イベント処理
     * @param dto NC104DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO initDoc(ND104DTO dto) {
        BaseDTO outdto = dto;

     // ページ数(現在:１ページ目から)
        dto.setPageCntCur(1);

        SelectHcpKmuReqDelEntity paramEntity = new SelectHcpKmuReqDelEntity();

        //申請IDをセット
        paramEntity.setParamReqId(dto.getParamReqId());
        if (StringUtils.isEmpty(dto.getParamReqId())) {
        	dto.setParamReqId("-");

        }

        //医師固定Cをセット
        paramEntity.setParamDocNo(dto.getParamDocNo());
        //施設固定コードをセット
        paramEntity.setParamInsNo(dto.getParamInsNo());
        paramEntity.setSqlId("selectHcpKmuReqDelShinki");//新規作成用SQL
        //画面初期表示時の帳票一覧を取得する
        List<SelectHcpKmuReqDelEntity> SelectHcpKmuReqNewList = dao.select(paramEntity);

        for (SelectHcpKmuReqDelEntity entity : SelectHcpKmuReqNewList) {

        	dto.setDocKanj(entity.getDocKanj());//医師・コメディカル名
        	dto.setDocNo(entity.getDocNo());//医師固定C
        	dto.setUltInsNo(entity.getUltInsNo());//ULT医師コード
        	dto.setInsAbbrName(entity.getInsAbbrName());//施設略式漢字名
        	dto.setDeptKj(entity.getDeptKj());//所属部科漢字名
        	dto.setTitleCodeName(entity.getTitleCodeName());//役職漢字名
        	dto.setJobFormBfName(entity.getJobFormBfName());//勤務形態名称
        	dto.setDccTypeBfName(entity.getDccTypeBfName());//薬審メンバー区分名称
        	dto.setUnivPosCodeBfName(entity.getUnivPosCodeBfName());//大学職位名称
        	dto.setInsNoMt(entity.getInsNoMt());//施設固定コード
        	dto.setDeptCodeBf(entity.getDeptCodeBf());//所属部科コード
        	dto.setDeptKn(entity.getDeptKn());//所属部科カナ名
        	dto.setTitleCodeBf(entity.getTitleCodeBf());//役職コード
        	dto.setJobFormBf(entity.getJobFormBf());//勤務形態コード
        	dto.setDccTypeBf(entity.getDccTypeBf());//薬審メンバー区分コード
        	dto.setUnivPosCodeBf(entity.getUnivPosCodeBf());//大学職位コード

        }

     // END UOC
        return outdto;
    }

    /**
     * 保存処理
     * @param dto NC104DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO save(ND104DTO dto) {
        BaseDTO outdto = dto;

     // START UOC
        LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();

        String reqId = dto.getParamReqId();

        // 現在日付を取得
        Date systemDate = DateUtils.getNowDate();
        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");

        LocalDateTime nowDate = LocalDateTime.now();
        ZoneId zone = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(nowDate, zone);

        //申請管理テーブル　データ定義
        // 申請ステータスを「01：保存済」として各テーブルに画面の申請情報を登録
           // 申請管理
           TRdmReqKnrEntity tRdmReqKnrEntity = new TRdmReqKnrEntity();
           tRdmReqKnrEntity.setReqId(dto.getParamReqId());
           TRdmReqKnrEntity tRdmReqKnrData = dao.selectByPK(tRdmReqKnrEntity);

           if(tRdmReqKnrData == null) {// insert処理

	           	// 新規にIDを取得 githubで実行
	          	SeqRdmReqIdEntity seqRdmReqIdEntity = new SeqRdmReqIdEntity();
	           	List<SeqRdmReqIdEntity> seqRdmReqIdDate = dao.select(seqRdmReqIdEntity);
	           	reqId = seqRdmReqIdDate.get(0).getReqId();
        	   dto.setParamReqId(reqId);

	           	// レコードを登録
	           	TRdmReqKnrEntity tRdmReqKnrInsData = new TRdmReqKnrEntity();
	           	tRdmReqKnrInsData.setReqId(dto.getParamReqId());
	           	if("JKN0813".equals(dto.getLoginJokenSetCd())) {
	           		// 承認者（管理者権限）が申請の場合、'2'(DSG起因)
	           		tRdmReqKnrInsData.setReqChl("2");
	           		tRdmReqKnrInsData.setReqKngKbn("2");
	           	} else {
	           		// "MRが申請の場合、'1'(MR起因)
	           		tRdmReqKnrInsData.setReqChl("1");
	           		tRdmReqKnrInsData.setReqKngKbn("1");
	           	}
	           	tRdmReqKnrInsData.setReqType("44");
	           	tRdmReqKnrInsData.setReqStsCd("01");

	           	String tekiyoYmd = dto.getFormTekiyoYmd();
	           	if(tekiyoYmd != null) {
	           		tekiyoYmd = tekiyoYmd.replace("-", "");
	           	}
	           	tRdmReqKnrInsData.setTekiyoYmd(tekiyoYmd);//適用日
	           	tRdmReqKnrInsData.setReqBrCd(loginInfo.getBrCode());//申請者医薬支店C
	           	tRdmReqKnrInsData.setReqDistCd(loginInfo.getDistCode()); //申請者医薬営業所C
	           	tRdmReqKnrInsData.setReqShzNm(loginInfo.getBumonRyakuName());//所属組織名（部門名略式）
	           	tRdmReqKnrInsData.setReqJgiNo(loginInfo.getJgiNo());//申請者従業員番号
	           	tRdmReqKnrInsData.setReqJgiName(loginInfo.getJgiName());//申請者氏名
	           	tRdmReqKnrInsData.setReqComment(dto.getReqComment());//申請者コメント
	           	tRdmReqKnrInsData.setInsNo(dto.getInsNoMt());//医師固定C
	           	tRdmReqKnrInsData.setInsShaYmd(systemDate);
	           	tRdmReqKnrInsData.setInsShaId(String.valueOf(loginInfo.getJgiNo()));
	           	tRdmReqKnrInsData.setUpdShaYmd(systemDate);
	           	tRdmReqKnrInsData.setUpdShaId(String.valueOf(loginInfo.getJgiNo()));
	           	//申請管理 insert処理
	           	dao.insertByValue(tRdmReqKnrInsData);
	       }else {
	           	// 更新
	           	TRdmReqKnrEntity tRdmReqKnrUpdData = new TRdmReqKnrEntity("updateNF211Data");
	           	tRdmReqKnrUpdData.setReqId(dto.getParamReqId());//申請ID

	           	if("13".equals(dto.getReqStsCd())) {//元が'13'(ULT承認待ち)の場合は'11'のまま
	           		tRdmReqKnrUpdData.setReqStsCd("11");//申請ステータス
	           	} else {
	           		tRdmReqKnrUpdData.setReqStsCd("01");//申請ステータス '01'（保存済)
	           	}
	           	String tekiyoYmd = dto.getFormTekiyoYmd();//適用開始日
	           	if(tekiyoYmd != null) {
	           		tekiyoYmd = tekiyoYmd.replace("-", "");
	           	}
	           	tRdmReqKnrUpdData.setTekiyoYmd(tekiyoYmd);//適用開始日
	           	tRdmReqKnrUpdData.setReqComment(dto.getReqComment());//申請コメント
	           	tRdmReqKnrUpdData.setUpdShaYmd(systemDate);//更新日
	           	tRdmReqKnrUpdData.setUpdShaId(String.valueOf(loginInfo.getJgiNo()));//更新者

	           	dao.update(tRdmReqKnrUpdData);
           }

           	//勤務先申請管理　データ格納
           if(tRdmReqKnrData == null) {//新規

	           	TRdmHcpKmuReqEntity tRdmHcpKmuReqInsData = new TRdmHcpKmuReqEntity();

	        	tRdmHcpKmuReqInsData.setReqId(dto.getParamReqId());
	        	tRdmHcpKmuReqInsData.setDocNo(dto.getDocNo());
	        	tRdmHcpKmuReqInsData.setInsNoMt(dto.getInsNoMt());
	        	tRdmHcpKmuReqInsData.setInsNoSk("Z");
	        	tRdmHcpKmuReqInsData.setJobFormBf(StringUtils.nvl(dto.getJobFormBf(), "Z"));
	        	tRdmHcpKmuReqInsData.setDeptCodeBf(StringUtils.nvl(dto.getDeptCodeBf(), "Z"));
	        	tRdmHcpKmuReqInsData.setDeptKanjiBf(StringUtils.nvl(dto.getDeptKj(), "Z"));
	        	tRdmHcpKmuReqInsData.setDeptKanaBf(StringUtils.nvl(dto.getDeptKn(), "Z"));
	        	tRdmHcpKmuReqInsData.setUnivPosCodeBf(dto.getUnivPosCodeBf());
	        	tRdmHcpKmuReqInsData.setTitleCodeBf(dto.getTitleCodeBf());
	        	tRdmHcpKmuReqInsData.setDccTypeBf(dto.getDccTypeBf());
	        	tRdmHcpKmuReqInsData.setJobFormAf("Z");
	        	tRdmHcpKmuReqInsData.setDeptCodeAf("Z");
	        	tRdmHcpKmuReqInsData.setDeptKanjiAf("Z");
	        	tRdmHcpKmuReqInsData.setDeptKanaAf("Z");
	        	tRdmHcpKmuReqInsData.setUltDocNo(dto.getUrlDocNo());
	        	tRdmHcpKmuReqInsData.setInsShaYmd(systemDate);
	        	tRdmHcpKmuReqInsData.setInsShaId(Integer.toString(loginInfo.getJgiNo()));
	        	tRdmHcpKmuReqInsData.setUpdShaYmd(systemDate);
	        	tRdmHcpKmuReqInsData.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));
	        	tRdmHcpKmuReqInsData.setSqlId("insertByValue");
	        	//勤務先申請管理　insert処理
	        	dao.insert(tRdmHcpKmuReqInsData);

           }else {//更新
	           	TRdmHcpKmuReqEntity tRdmHcpKmuReqUpdData = new TRdmHcpKmuReqEntity("updateND104Data");
	           	tRdmHcpKmuReqUpdData.setReqId(dto.getParamReqId());
	           	tRdmHcpKmuReqUpdData.setUpdShaYmd(systemDate);//更新日
	           	tRdmHcpKmuReqUpdData.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));//更新者

	           	dao.update(tRdmHcpKmuReqUpdData);
           }

        // END UOC
        return outdto;
    }

    /**
    *
    * @param indto
    * @return
    */
   @Transactional
   public BaseDTO errorCheck(ND104DTO indto) {
       BaseDTO outdto = indto;

       // START UOC
       SelectHcpKmuReqDelEntity paramEntity = new SelectHcpKmuReqDelEntity();

       //医師固定Cをセット
       paramEntity.setDocNo(indto.getDocNo());
       //施設固定Cをセット
       paramEntity.setInsNoMt(indto.getInsNoMt());

       //重複申請チェック
	   	paramEntity.setSqlId("errorCheck1");
	   	List<SelectHcpKmuReqDelEntity> kinmuJuhuku = dao.select(paramEntity);
	   	//重複申請チェックエラーがある場合
	   	if (!CollectionUtils.isEmpty(kinmuJuhuku)) {
	   		indto.setErrorCheckFlg("1");
	   		return outdto;
	    }

	   	//勤務先0件チェック
	   	paramEntity.setSqlId("errorCheck2");
	   	List<SelectHcpKmuReqDelEntity> kinmu0 = dao.select(paramEntity);
	   	//勤務先が１件以下または空の場合エラー
	   	if (kinmu0.size() <= 1) {
	   		indto.setErrorCheckFlg("2");
	   		return outdto;
	    }

       // END UOC
       return outdto;
   }



    /**
    *
    * @param indto
    * @return
    */
   @Transactional
   public BaseDTO cancel(ND104DTO indto) {
       BaseDTO outdto = indto;

       // START UOC
    // 申請管理を物理削除
       TRdmReqKnrEntity tRdmReqKnrEntity = new TRdmReqKnrEntity();
       tRdmReqKnrEntity.setReqId(indto.getParamReqId());
       dao.deleteByPK(tRdmReqKnrEntity);

       // END UOC
       return outdto;
   }


}
