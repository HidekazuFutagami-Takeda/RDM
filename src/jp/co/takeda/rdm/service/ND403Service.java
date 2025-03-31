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
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import jp.co.takeda.rdm.common.BaseDTO;
import jp.co.takeda.rdm.common.BaseInfoHolder;
import jp.co.takeda.rdm.common.BaseService;
import jp.co.takeda.rdm.common.LoginInfo;
import jp.co.takeda.rdm.dto.KmuIkkatsuData;
import jp.co.takeda.rdm.dto.ND403DTO;
import jp.co.takeda.rdm.entity.MRdmHcpYakusyokuEntity;
import jp.co.takeda.rdm.entity.join.MRdmCodeMstEntity;
import jp.co.takeda.rdm.entity.join.SelectHcpKmuReqNewEntity;
import jp.co.takeda.rdm.entity.join.SelectNd401InitEntity;
import jp.co.takeda.rdm.entity.join.SeqRdmReqIdEntity;
import jp.co.takeda.rdm.entity.join.TRdmHcpKmuReqEntity;
import jp.co.takeda.rdm.entity.join.TRdmReqKnrEntity;
import jp.co.takeda.rdm.util.DateUtils;
import jp.co.takeda.rdm.util.RdmConstantsData;
import jp.co.takeda.rdm.util.StringUtils;



/**
 * Serviceクラス（ND403)
 * @generated
 */
@Named
public class ND403Service extends BaseService {

	//ログインユーザ情報取得
    LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();

    boolean errChk = false;
	String msgStr = "";
	String tmpMsgStr = "";
	int len = 0;

	/**
     * イベント処理
     * @param dto ND403DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO init(ND403DTO indto) {
        BaseDTO outdto = indto;

    	//1-1 権限判定
        LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();
        //ND401のデータ
        List<KmuIkkatsuData> kmuIkkatsuDataList = indto.getKmuIkkatsuDataList();

      //役職プルダウン
    	SelectNd401InitEntity selectNd401DmcMstPostEntity = new SelectNd401InitEntity();
    	selectNd401DmcMstPostEntity.setSqlId("selectCntNd401DmcMstPost");
    	List<SelectNd401InitEntity> selectNd401DmcMstPostListList = dao.select(selectNd401DmcMstPostEntity);

        //ND403に格納用
        List<KmuIkkatsuData> kmuIkkatsuDataND403List = new ArrayList<KmuIkkatsuData>();

        for (KmuIkkatsuData entity : kmuIkkatsuDataList ) {
        	KmuIkkatsuData data = new KmuIkkatsuData();
        	//変更したデータがある場合格納
        	if ( !(Objects.equals(entity.getPreTitleCode(), entity.getPostTitleCode()))
        		||	!(Objects.equals(entity.getPreTitleCode(), entity.getPostTitleCode()))
        		) {

        		data.setInsAbbrName(entity.getInsAbbrName());//施設名
                data.setInsNo(entity.getInsNo());//施設固定コード
                data.setDocNo(entity.getDocNo());//医師固定コード
                data.setDocKanj(entity.getDocKanj());//氏名（漢字）
            	//役職データ_取り出す
                for (SelectNd401InitEntity outEntity : selectNd401DmcMstPostListList) {
                	if (Objects.equals(entity.getPreTitleCode(), outEntity.getPuldownTitleCode())) {
                		data.setPreTitleKj(outEntity.getPuldownTitleKj());//役職（変更前）
                	}
                	if (Objects.equals(entity.getPostTitleCode(), outEntity.getPuldownTitleCode())) {
                		data.setPostTitleKj(outEntity.getPuldownTitleKj());//役職（変更後）
                	}
                }

                data.setPreDeptKanji(entity.getPreDeptKanji());//所属部科名（漢字）（変更前）
                data.setPostDeptKanji(entity.getPostDeptKanji());//所属部科名（漢字）（変更後）
                data.setPreTitleCode(entity.getPreTitleCode());//役職コード（変更前）
                data.setPostTitleCode(entity.getPostTitleCode());//役職コード（変更後）
                data.setPreDeptCode(entity.getPreDeptCode());//所属部科コード（変更前）
                data.setPostDeptCode(entity.getPostDeptCode());//所属部科コード（変更後）
                data.setPreDeptKana(entity.getPreDeptKana());//所属部科名（カナ）（変更前）
                data.setPostDeptKana(entity.getPostDeptKana());//所属部科名（カナ）（変更後）
                data.setJobForm(entity.getJobForm());//勤務形態
                data.setUnivPosCode(entity.getUnivPosCode());//大学職位コード
                data.setDcc(entity.getDcc());//薬審メンバー区分
                data.setUltInsNo(entity.getUltInsNo());//ULT施設コード
                data.setUltDocNo(entity.getUltDocNo());//ULT医師コード

        		kmuIkkatsuDataND403List.add(data);
        	}
        }
        indto.setKmuIkkatsuDataList(kmuIkkatsuDataND403List);

        //初期表示画面フラグ = 1(初期化)
        indto.setPageFlag("1");

        //ページNO
        indto.setPageCntCur(1);
        return outdto;

    }





}
