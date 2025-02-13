/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

import javax.inject.Named;

import jp.co.takeda.rdm.common.BaseDTO;
import jp.co.takeda.rdm.common.BaseInfoHolder;
import jp.co.takeda.rdm.common.BaseService;
import jp.co.takeda.rdm.common.LoginInfo;
import jp.co.takeda.rdm.dto.ND103DTO;
import jp.co.takeda.rdm.entity.MRdmHcpYakusyokuEntity;
import jp.co.takeda.rdm.entity.join.InsertRdmHcpKmuNewEntity;
import jp.co.takeda.rdm.entity.join.InsertRdmReqKnrNewEntity;
import jp.co.takeda.rdm.entity.join.MRdmCodeMstEntity;
import jp.co.takeda.rdm.entity.join.SelectHcpKmuReqNewEntity;
import jp.co.takeda.rdm.entity.join.SeqRdmReqIdEntity;
import jp.co.takeda.rdm.entity.join.UpdateRdmHcpKmuNewEntity;
import jp.co.takeda.rdm.entity.join.UpdateRdmReqKnrNewEntity;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;



/**
 * Serviceクラス（ND103)
 * @generated
 */
@Named
public class ND103Service extends BaseService {

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
    public BaseDTO initReq(ND103DTO dto) {
        BaseDTO outdto = dto;
        // START UOC

        // ページ数(現在:１ページ目から)
        dto.setPageCntCur(1);

        SelectHcpKmuReqNewEntity paramEntity = new SelectHcpKmuReqNewEntity();

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
        List<MRdmCodeMstEntity> SelectparamStatusList = dao.select(paramStatus);

        //画面初期表示時の帳票一覧を取得する
        List<SelectHcpKmuReqNewEntity> SelectHcpKmuReqNewList = dao.select(paramEntity);

        for (SelectHcpKmuReqNewEntity entity : SelectHcpKmuReqNewList) {
        	//申請者所属
        	dto.setReqShz(entity.getReqShz());
        	//申請ステータス(名称)
        	for (MRdmCodeMstEntity outEntity : SelectparamStatusList) {
        		if (Objects.deepEquals(entity.getReqSts(),outEntity.getValue1())) {
        			dto.setReqSts(outEntity.getValue1Kanj());
        			break;
        		}
            }

        	//申請者氏名
        	dto.setJgiName(entity.getJgiName());
        	//申請日時
        	String reqYmdhms = entity.getReqYmdhms();
        	String yyyy = reqYmdhms.substring(0,4);
        	String  mm = reqYmdhms.substring(4,6);
        	String  dd = reqYmdhms.substring(6,8);
        	dto.setReqYmdhms(yyyy + "-" + mm + "-" + dd);
        	//申請者従業員番号
        	dto.setReqJgiNo(entity.getReqJgiNo());
        	//申請者所属リージョン
        	dto.setBrCode(entity.getBrCode());
        	//申請者所属エリア
        	dto.setReqDistCode(entity.getReqDistCode());
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
        	dto.setTitleCodeAf(entity.getTitleCodeAf());

        	//勤務形態(異動先)
        	dto.setJobFormAf(entity.getJobFormAf());
        	//薬審メンバー区分(異動先)
        	dto.setDccTypeAf(entity.getDccTypeAf());
        	//大学職位コード(異動先)
        	dto.setUnivPosCodeAf(entity.getUnivPosCodeAf());
        	//適用開始日
        	String tekiyoYmd = entity.getTekiyoYmd();
        	String Tyyyy = tekiyoYmd.substring(0,4);
        	String  Tmm = tekiyoYmd.substring(4,6);
        	String  Tdd = tekiyoYmd.substring(6,8);
        	dto.setTekiyoYmd(Tyyyy + "-" + Tmm + "-" + Tdd);
        	//施設固定コード(異動先)
        	dto.setInsNoSk(entity.getInsNoSk());
        	//ULT施設コード
        	dto.setUltInsNo(entity.getUltInsNo());
        	//所属部科コード(異動先)
        	dto.setDeptCodeAf(entity.getDeptCodeAf());
        	//所属部科カナ名
        	dto.setDeptKn(entity.getDeptKn());
        	//申請コメント
        	dto.setReqComment(entity.getReqComment());
        	//却下コメント
        	dto.setAprComment(entity.getAprComment());

        }
        //プルダウン生成へ
        pullDown(dto);

        // END UOC
        return outdto;
    }

    /**
     * イベント処理
     * @param dto NC103DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO initDoc(ND103DTO dto) {
        BaseDTO outdto = dto;

     // ページ数(現在:１ページ目から)
        dto.setPageCntCur(1);

        SelectHcpKmuReqNewEntity paramEntity = new SelectHcpKmuReqNewEntity();

        //申請IDをセット
        paramEntity.setParamReqId(dto.getParamReqId());
        if (StringUtils.isEmpty(dto.getParamReqId())) {
        	dto.setParamReqId("-");
        }
        dto.setReqShz("-");//申請者所属
        dto.setReqSts("-");//申請ID
        dto.setJgiName("-");//申請者氏名
        dto.setReqYmdhms("-");//申請日時

        //医師固定Cをセット
        paramEntity.setParamDocNo(dto.getParamDocNo());
        //画面初期表示時の帳票一覧を取得する
        List<SelectHcpKmuReqNewEntity> SelectHcpKmuReqNewList = dao.select(paramEntity);

        for (SelectHcpKmuReqNewEntity entity : SelectHcpKmuReqNewList) {

        	dto.setDocKanj(entity.getDocKanj());
        	dto.setDocNo(entity.getDocNo());
        	dto.setUltInsNo(entity.getUltInsNo());
        }

      //プルダウン生成へ
        pullDown(dto);

     // END UOC
        return outdto;
    }

    /**
     * 保存処理
     * @param dto NC103DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO save(ND103DTO dto) {
        BaseDTO outdto = dto;

     	//申請管理テーブル定義
        InsertRdmReqKnrNewEntity paramInsertRdmReqKnr  = new InsertRdmReqKnrNewEntity();
        //勤務先申請管理テーブル定義
        InsertRdmHcpKmuNewEntity paramInsertRdmHcpKmu = new InsertRdmHcpKmuNewEntity();

     // 現在日時を取得
        LocalDateTime nowDate = LocalDateTime.now();
        ZoneId zone = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(nowDate, zone);
        Instant instant = zonedDateTime.toInstant();

        //申請ID作成シーケンス
        SeqRdmReqIdEntity seqRdmReqIdEntity = new SeqRdmReqIdEntity();
        List<SeqRdmReqIdEntity> paramSeqRdmReqId = dao.select(seqRdmReqIdEntity);
        String reqId = null;

        for (SeqRdmReqIdEntity entitry : paramSeqRdmReqId) {
        	reqId = entitry.getReqId();
        }

        //申請管理テーブル　データ定義
        paramInsertRdmReqKnr.setReqId(reqId);
        paramInsertRdmReqKnr.setReqChl("1");//MR
        //paramInsertRdmReqKnr.setReqChl("2");//仮　管理者
        paramInsertRdmReqKnr.setReqType("41");//'41'(医師勤務先追加)
        paramInsertRdmReqKnr.setReqSts("01");//'01'（保存済）※元が'13'(ULT承認待ち)の場合は'11'のままとする
        //適用開始日
        paramInsertRdmReqKnr.setTekiyoYmd(dto.getTekiyoYmd().replace("-", ""));
        paramInsertRdmReqKnr.setBrCode(dto.getBrCode());//申請者所属リージョン＝ログインユーザ情報
        paramInsertRdmReqKnr.setReqDistCode(dto.getReqDistCode());//申請者所属エリア＝ログインユーザ情報
        paramInsertRdmReqKnr.setReqShz((dto.getReqShz()));//申請者所属＝ログインユーザ情報
        paramInsertRdmReqKnr.setReqJgiNo(dto.getLoginJgiNo());//申請者従業員番号＝ログインユーザ情報
        paramInsertRdmReqKnr.setReqJgiName(dto.getJgiName());//申請者氏名＝ログインユーザ情報
        paramInsertRdmReqKnr.setReqYmdhms(null);
        paramInsertRdmReqKnr.setReqMemo(null);
        paramInsertRdmReqKnr.setReqComment(dto.getReqComment());//申請コメント
        /*
         *MR権限の場合、'1'(MR権限による申請)をセット
         *管理者権限の場合、'2'(管理者権限による申請)をセット
         * */
        paramInsertRdmReqKnr.setReqKngKbn("2");//申請者権限区分
//        paramInsertRdmReqKnr.setReqKngKbn("1");//申請者権限区分
        paramInsertRdmReqKnr.setShnFlg(null);
        paramInsertRdmReqKnr.setShnBrCode(null);
        paramInsertRdmReqKnr.setShnDistCode(null);
        paramInsertRdmReqKnr.setShnShz(null);
        paramInsertRdmReqKnr.setShnJgiNo(null);
        paramInsertRdmReqKnr.setShnShaId(null);
        paramInsertRdmReqKnr.setShnYmdHms(null);
        paramInsertRdmReqKnr.setAprBrCode(null);
        paramInsertRdmReqKnr.setAprDistCode(null);
        paramInsertRdmReqKnr.setAprShz(null);
        paramInsertRdmReqKnr.setAprJgiNo(null);
        paramInsertRdmReqKnr.setAprShaId(null);
        paramInsertRdmReqKnr.setAprYmdhms(null);
        paramInsertRdmReqKnr.setAprHryFlg(null);
        paramInsertRdmReqKnr.setAprMemo(null);
        paramInsertRdmReqKnr.setAprComment(null);
        paramInsertRdmReqKnr.setInsNo(dto.getInsNoSk());//施設固定コード(異動先)
        paramInsertRdmReqKnr.setDocNo(dto.getParamDocNo());//医師固定C
        paramInsertRdmReqKnr.setUpdMstYmd(null);
        paramInsertRdmReqKnr.setFbReqFlg(null);
        paramInsertRdmReqKnr.setFbReqId(null);
        paramInsertRdmReqKnr.setFbAnsId(null);
        paramInsertRdmReqKnr.setFbDataType(null);
        paramInsertRdmReqKnr.setFbRecId(null);
        paramInsertRdmReqKnr.setFbUpdKbn(null);
        paramInsertRdmReqKnr.setFbPrcType(null);
        paramInsertRdmReqKnr.setInsShaYmd(Date.from(instant));
        paramInsertRdmReqKnr.setInsShaId(String.valueOf(dto.getLoginJgiNo()));
        paramInsertRdmReqKnr.setUpdShaYmd(Date.from(instant));
        paramInsertRdmReqKnr.setUpdShaId(String.valueOf(dto.getLoginJgiNo()));
        //申請管理テーブル 更新処理
        dao.insert(paramInsertRdmReqKnr);

      //勤務先申請管理テーブル　データ定義
        paramInsertRdmHcpKmu.setReqId(reqId);
        paramInsertRdmHcpKmu.setDocNo(dto.getDocNo());
        paramInsertRdmHcpKmu.setInsNoMt(null);
        paramInsertRdmHcpKmu.setTrnKbn(null);
        paramInsertRdmHcpKmu.setInsNoSk(null);
        paramInsertRdmHcpKmu.setJobFromBf(null);
        paramInsertRdmHcpKmu.setDeptCodeBf(null);
        paramInsertRdmHcpKmu.setDeotKanjiBf(null);
        paramInsertRdmHcpKmu.setDeptKanaBf(null);
        paramInsertRdmHcpKmu.setUnivPosCodeBf(null);
        paramInsertRdmHcpKmu.setTitleCodeBf(null);
        paramInsertRdmHcpKmu.setDccTypeBf(null);
        paramInsertRdmHcpKmu.setJobFromAf(dto.getJobFormAf());// 勤務形態(異動先)
        paramInsertRdmHcpKmu.setDeptCodeAf(dto.getDeptCodeAf());//所属部科コード(異動先)
        paramInsertRdmHcpKmu.setDeptKanjiAf(dto.getDeptKj());//所属部科名（漢字）(異動先)
        paramInsertRdmHcpKmu.setDeptKanaAf(dto.getDeptKn());//所属部科名（カナ）(異動先)
        paramInsertRdmHcpKmu.setUnivPosCodeAf(dto.getUnivPosCodeAf());//大学職位コード(異動先)
        paramInsertRdmHcpKmu.setTitleCodeAf(dto.getTitleCodeAf());//役職コード(異動先)
        paramInsertRdmHcpKmu.setDccTypeAf(dto.getDccTypeAf());//薬審メンバー区分(異動先)
        paramInsertRdmHcpKmu.setUltDocNo(dto.getUrlDocNo());//ULT医師コード
        paramInsertRdmHcpKmu.setUltInsNo(dto.getUltInsNo());//ULT施設コード
        paramInsertRdmHcpKmu.setInsShaYmd(Date.from(instant));
        paramInsertRdmHcpKmu.setInsShaId(String.valueOf(dto.getLoginJgiNo()));
        paramInsertRdmHcpKmu.setUpdShaYmd(Date.from(instant));
        paramInsertRdmHcpKmu.setUpdShaId(String.valueOf(dto.getLoginJgiNo()));
        //勤務先管理テーブル 更新処理
        dao.insert(paramInsertRdmHcpKmu);

        // END UOC
        return outdto;
    }

    /**
     * 更新処理
     * @param dto NC204DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO update(ND103DTO dto) {
        BaseDTO outdto = dto;

        //申請管理テーブル定義
        UpdateRdmReqKnrNewEntity paramUpdateRdmReqKnr = new UpdateRdmReqKnrNewEntity();
        //勤務先申請管理テーブル定義
        UpdateRdmHcpKmuNewEntity paramUpdateRdmHcpKmu = new UpdateRdmHcpKmuNewEntity();
        // 現在日時を取得
        LocalDateTime nowDate = LocalDateTime.now();
        ZoneId zone = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(nowDate, zone);
        Instant instant = zonedDateTime.toInstant();

        //申請管理テーブル　データ定義
        paramUpdateRdmReqKnr.setReqId(dto.getParamReqId());
        paramUpdateRdmReqKnr.setReqChl("1");//MR
        //paramUpdateRdmReqKnr.setReqChl("2");//仮　管理者
        paramUpdateRdmReqKnr.setReqType("41");//'41'(医師勤務先追加)
        paramUpdateRdmReqKnr.setReqSts("01");//'01'（保存済）※元が'13'(ULT承認待ち)の場合は'11'のままとする
        //適用開始日
        paramUpdateRdmReqKnr.setTekiyoYmd(dto.getTekiyoYmd().replace("-", ""));
        paramUpdateRdmReqKnr.setBrCode(dto.getBrCode());//申請者所属リージョン＝ログインユーザ情報
        paramUpdateRdmReqKnr.setReqDistCode(dto.getReqDistCode());//申請者所属エリア＝ログインユーザ情報
        paramUpdateRdmReqKnr.setReqShz((dto.getReqShz()));//申請者所属＝ログインユーザ情報
        paramUpdateRdmReqKnr.setReqJgiNo(dto.getLoginJgiNo());//申請者従業員番号＝ログインユーザ情報
        paramUpdateRdmReqKnr.setReqJgiName(dto.getJgiName());//申請者氏名＝ログインユーザ情報
        paramUpdateRdmReqKnr.setReqYmdhms(null);
        paramUpdateRdmReqKnr.setReqMemo(null);
        paramUpdateRdmReqKnr.setReqComment(dto.getReqComment());//申請コメント
        /*
         *MR権限の場合、'1'(MR権限による申請)をセット
         *管理者権限の場合、'2'(管理者権限による申請)をセット
         * */
        paramUpdateRdmReqKnr.setReqKngKbn("2");//申請者権限区分
//        paramUpdateRdmReqKnr.setReqKngKbn("1");//申請者権限区分
        paramUpdateRdmReqKnr.setShnFlg(null);
        paramUpdateRdmReqKnr.setShnBrCode(null);
        paramUpdateRdmReqKnr.setShnDistCode(null);
        paramUpdateRdmReqKnr.setShnShz(null);
        paramUpdateRdmReqKnr.setShnJgiNo(null);
        paramUpdateRdmReqKnr.setShnShaId(null);
        paramUpdateRdmReqKnr.setShnYmdHms(null);
        paramUpdateRdmReqKnr.setAprBrCode(null);
        paramUpdateRdmReqKnr.setAprDistCode(null);
        paramUpdateRdmReqKnr.setAprShz(null);
        paramUpdateRdmReqKnr.setAprJgiNo(null);
        paramUpdateRdmReqKnr.setAprShaId(null);
        paramUpdateRdmReqKnr.setAprYmdhms(null);
        paramUpdateRdmReqKnr.setAprHryFlg(null);
        paramUpdateRdmReqKnr.setAprMemo(null);
        paramUpdateRdmReqKnr.setAprComment(null);
        paramUpdateRdmReqKnr.setInsNo(dto.getInsNoSk());//施設固定コード(異動先)
        paramUpdateRdmReqKnr.setDocNo(dto.getParamDocNo());//医師固定C
        paramUpdateRdmReqKnr.setUpdMstYmd(null);
        paramUpdateRdmReqKnr.setFbReqFlg(null);
        paramUpdateRdmReqKnr.setFbReqId(null);
        paramUpdateRdmReqKnr.setFbAnsId(null);
        paramUpdateRdmReqKnr.setFbDataType(null);
        paramUpdateRdmReqKnr.setFbRecId(null);
        paramUpdateRdmReqKnr.setFbUpdKbn(null);
        paramUpdateRdmReqKnr.setFbPrcType(null);
        paramUpdateRdmReqKnr.setInsShaYmd(Date.from(instant));
        paramUpdateRdmReqKnr.setInsShaId(String.valueOf(dto.getLoginJgiNo()));
        paramUpdateRdmReqKnr.setUpdShaYmd(Date.from(instant));
        paramUpdateRdmReqKnr.setUpdShaId(String.valueOf(dto.getLoginJgiNo()));

        //申請管理テーブル 更新処理
        dao.update(paramUpdateRdmReqKnr);

        //勤務先申請管理テーブル　データ定義
        paramUpdateRdmHcpKmu.setReqId(dto.getParamReqId());
        paramUpdateRdmHcpKmu.setDocNo(dto.getDocNo());
        paramUpdateRdmHcpKmu.setInsNoMt(null);
        paramUpdateRdmHcpKmu.setTrnKbn(null);
        paramUpdateRdmHcpKmu.setInsNoSk(null);
        paramUpdateRdmHcpKmu.setJobFromBf(null);
        paramUpdateRdmHcpKmu.setDeptCodeBf(null);
        paramUpdateRdmHcpKmu.setDeotKanjiBf(null);
        paramUpdateRdmHcpKmu.setDeptKanaBf(null);
        paramUpdateRdmHcpKmu.setUnivPosCodeBf(null);
        paramUpdateRdmHcpKmu.setTitleCodeBf(null);
        paramUpdateRdmHcpKmu.setDccTypeBf(null);
        paramUpdateRdmHcpKmu.setJobFromAf(dto.getJobFormAf());// 勤務形態(異動先)
        paramUpdateRdmHcpKmu.setDeptCodeAf(dto.getDeptCodeAf());//所属部科コード(異動先)
        paramUpdateRdmHcpKmu.setDeptKanjiAf(dto.getDeptKj());//所属部科名（漢字）(異動先)
        paramUpdateRdmHcpKmu.setDeptKanaAf(dto.getDeptKn());//所属部科名（カナ）(異動先)
        paramUpdateRdmHcpKmu.setUnivPosCodeAf(dto.getUnivPosCodeAf());//大学職位コード(異動先)
        paramUpdateRdmHcpKmu.setTitleCodeAf(dto.getTitleCodeAf());//役職コード(異動先)
        paramUpdateRdmHcpKmu.setDccTypeAf(dto.getDccTypeAf());//薬審メンバー区分(異動先)
        paramUpdateRdmHcpKmu.setUltDocNo(dto.getUrlDocNo());//ULT医師コード
        paramUpdateRdmHcpKmu.setUltInsNo(dto.getUltInsNo());//ULT施設コード
        paramUpdateRdmHcpKmu.setInsShaYmd(Date.from(instant));
        paramUpdateRdmHcpKmu.setInsShaId(String.valueOf(dto.getLoginJgiNo()));
        paramUpdateRdmHcpKmu.setUpdShaYmd(Date.from(instant));
        paramUpdateRdmHcpKmu.setUpdShaId(String.valueOf(dto.getLoginJgiNo()));

        //勤務先管理テーブル 更新処理
        dao.update(paramUpdateRdmHcpKmu);

     // END UOC
        return outdto;
    }

    /**
     * 更新処理
     * @param dto NC204DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO delete(ND103DTO dto) {
        BaseDTO outdto = dto;

        SelectHcpKmuReqNewEntity paramEntity = new SelectHcpKmuReqNewEntity();
        paramEntity.setParamReqId(dto.getParamReqId());
        paramEntity.setSqlId("deleteRdmHcpKmu");//SQLid　勤務先申請管理
        //勤務先申請管理 削除処理
        dao.delete(paramEntity);

        paramEntity.setSqlId("deleteRdmReqKnr");//SQLid　申請管理
        //申請管理 削除処理
        dao.delete(paramEntity);

     // END UOC
        return outdto;
    }


    /**
     * 更新処理
     * @param dto NC204DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO pullDown(ND103DTO dto) {
        BaseDTO outdto = dto;

      //医師_役職マスタ_生成用エンティティ
    	MRdmHcpYakusyokuEntity paramYakusyoku = new MRdmHcpYakusyokuEntity();
    	//検索条件_大学職位利用フラグ=0
    	paramYakusyoku.setUnivTitleFlg("0");
        //役職の帳票一覧を取得する
        List<MRdmHcpYakusyokuEntity> SelectYakusyoku = dao.select(paramYakusyoku);
        //役職データ_取り出す
        LinkedHashMap<String, String> yakusyokuMap = new LinkedHashMap<String, String>();
        yakusyokuMap.put("", "--なし--");
        for (MRdmHcpYakusyokuEntity outEntity : SelectYakusyoku) {
        	yakusyokuMap.put(outEntity.getTitleCode(), outEntity.getTitleKj());
        }
        //役職区分を格納する
        dto.setYakusyokuMap(yakusyokuMap);

        //医師_役職マスタ_生成用エンティティ
        MRdmHcpYakusyokuEntity paramDaigakuSyokui = new MRdmHcpYakusyokuEntity();
        //検索条件_大学職位利用フラグ=0
    	paramDaigakuSyokui.setUnivTitleFlg("1");
        //大学職位の帳票一覧を取得する
        List<MRdmHcpYakusyokuEntity> SelectDaigakuSyokui = dao.select(paramDaigakuSyokui);
        //大学職位データ_取り出す
        LinkedHashMap<String, String> DaigakuSyokuiMap = new LinkedHashMap<String, String>();
        DaigakuSyokuiMap.put("", "--なし--");
        for (MRdmHcpYakusyokuEntity outEntity : SelectDaigakuSyokui) {
        	DaigakuSyokuiMap.put(outEntity.getTitleCode(), outEntity.getTitleKj());
        }
        //大学職位を格納する
        dto.setDaigakuSyokuiMap(DaigakuSyokuiMap);

        //勤務形態_生成用エンティティ
    	MRdmCodeMstEntity paramKinmuKeitai = new MRdmCodeMstEntity();
    	//検索条件_勤務形態
    	paramKinmuKeitai.setCodeName("JOB_FORM");
        //勤務形態の帳票一覧を取得する
        List<MRdmCodeMstEntity> SelectKinmuKeitaiList = dao.select(paramKinmuKeitai);
        //勤務形態データ_取り出す
        LinkedHashMap<String, String> KinmuKeitai = new LinkedHashMap<String, String>();
        KinmuKeitai.put("", "--なし--");
        for (MRdmCodeMstEntity outEntity : SelectKinmuKeitaiList) {
        	KinmuKeitai.put(outEntity.getValue1(), outEntity.getValue1Kanj());
        }
        //勤務形態を格納する
        dto.setKinmuKeitaiMap(KinmuKeitai);

        //薬審メンバー区分_生成用エンティティ
    	MRdmCodeMstEntity paramYakushin = new MRdmCodeMstEntity();
    	//検索条件_薬審メンバー区分
    	paramYakushin.setCodeName("DCC");
        //薬審メンバー区分の帳票一覧を取得する
        List<MRdmCodeMstEntity> SelectYakushinList = dao.select(paramYakushin);
        //薬審メンバー区分データ_取り出す
        LinkedHashMap<String, String> yakushinMap = new LinkedHashMap<String, String>();
        yakushinMap.put("", "--なし--");
        for (MRdmCodeMstEntity outEntity : SelectYakushinList) {
        	yakushinMap.put(outEntity.getValue1(), outEntity.getValue1Kanj());
        }
        //薬審メンバー区分を格納する
        dto.setYakushinMap(yakushinMap);
     // END UOC
        return outdto;
    }


}
