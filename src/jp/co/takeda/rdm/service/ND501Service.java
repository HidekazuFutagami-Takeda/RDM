/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import jp.co.takeda.rdm.common.BaseDTO;
import jp.co.takeda.rdm.common.BaseEntity;
import jp.co.takeda.rdm.common.BaseInfoHolder;
import jp.co.takeda.rdm.common.BaseService;
import jp.co.takeda.rdm.common.LoginInfo;
import jp.co.takeda.rdm.dto.HcpUpdHstDataList;
import jp.co.takeda.rdm.dto.ND501DTO;
import jp.co.takeda.rdm.entity.MRdmHcpYakusyokuEntity;
import jp.co.takeda.rdm.entity.join.MRdmCodeMstEntity;
import jp.co.takeda.rdm.entity.join.MRdmComCalUsrEntity;
import jp.co.takeda.rdm.entity.join.MRdmHcpPubInstitutionEntity;
import jp.co.takeda.rdm.entity.join.MRdmHcpShusshinkoEntity;
import jp.co.takeda.rdm.entity.join.MRdmHcpSpDiseaseEntity;
import jp.co.takeda.rdm.entity.join.MRdmHcpSpLiverEntity;
import jp.co.takeda.rdm.entity.join.MRdmHcpUpdHstListEntity;
import jp.co.takeda.rdm.entity.join.SelectHenkanListEntity;
import jp.co.takeda.rdm.entity.join.SelectParamND501Entity;



/**
 * Serviceクラス（ND501)
 * @generated
 */
@Named
public class ND501Service extends BaseService {

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
    public BaseDTO init(ND501DTO dto) {
        BaseDTO outdto = dto;
        // START UOC

        // ページ数(現在:１ページ目から)
        dto.setPageCntCur(1);

        //プルダウン・日付データ一覧取得
        outdto = pharmTypeList(dto);

        // END UOC
        return outdto;
    }

    /**
     * 検索処理
     * @param dto ND501DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO search(ND501DTO dto) {
        // START UOC
    	//件数リセット
    	dto.setLineCntAll(0);

        if (Objects.equals(dto.getSelectListChange(),"0")) {
        	searchUpdHst(dto);//医師基本情報　検索処理
        }
        if (Objects.equals(dto.getSelectListChange(),"1")) {
        	searchKmuHst(dto);//医師勤務情報　検索処理
        }
        if (Objects.equals(dto.getSelectListChange(),"2")) {
        	searchHcpSociety(dto);//医師所属学会　検索処理
        }
        if (Objects.equals(dto.getSelectListChange(),"3")) {
        	searchPublicHst(dto);//公的機関　検索処理
        }
        // END UOC
        return dto;
    }

    /**
     * 勤務先情報 検索処理
     * @param dto ND501DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO searchKmuHst(ND501DTO dto) {
        BaseDTO outdto = dto;

        //勤務先情報_検索件数取得の検索条件の設定
        MRdmHcpUpdHstListEntity paramEntity = new MRdmHcpUpdHstListEntity();

        //条件セット
        paramEntity.setJokenSetCd(dto.getJokenSetCd());

        //検索条件_従業員番号(管理者)
        if (StringUtils.isEmpty(dto.getKensakuJgiNo())) {
        	dto.setKensakuJgiNo(0);
        }
        paramEntity.setKensakuJgiNo(dto.getKensakuJgiNo());

        //検索条件_医薬支店C_申請者所属リージョン(管理者)
        if (StringUtils.isEmpty(dto.getKensakuShinseiBrCode())) {
        	dto.setKensakuShinseiBrCode(null);
        }
        paramEntity.setKensakuShinseiBrCode(dto.getKensakuShinseiBrCode());

        //検索条件_医薬営業所C_申請者所属エリア(管理者)
        if (StringUtils.isEmpty(dto.getKensakuShinseiDistCode())) {
        	dto.setKensakuShinseiDistCode(null);
        }
        paramEntity.setKensakuShinseiDistCode(dto.getKensakuShinseiDistCode());

        //検索条件_医薬支店C_担当者所属リージョン(管理者)
        if (StringUtils.isEmpty(dto.getKensakuSTantouBrCode())) {
        	dto.setKensakuSTantouBrCode(null);
        }
        paramEntity.setKensakuSTantouBrCode(dto.getKensakuSTantouBrCode());

        //検索条件_医薬営業所C_担当者所属エリア(管理者)
        if (StringUtils.isEmpty(dto.getKensakuTantouDistCode())) {
        	dto.setKensakuTantouDistCode(null);
        }
        paramEntity.setKensakuTantouDistCode(dto.getKensakuTantouDistCode());

        //検索条件_申請者(管理者)
        if (StringUtils.isEmpty(dto.getKensakuReqJgiName())) {
        	dto.setKensakuReqJgiName(null);
        }
        paramEntity.setKensakuReqJgiName(dto.getKensakuReqJgiName());

        //従業員番号(MR)
        if (StringUtils.isEmpty(dto.getMrJgiNo())) {
        	dto.setMrJgiNo(0);
        }
        paramEntity.setMrJgiNo(dto.getMrJgiNo());

        //医薬支店C_申請者所属リージョン(MR)
        if (StringUtils.isEmpty(dto.getMrBrCode())) {
        	dto.setMrBrCode(null);
        }
        paramEntity.setMrBrCode(dto.getMrBrCode());

        //医薬営業所C_申請者所属エリア(MR)
        if (StringUtils.isEmpty(dto.getMrDistCode())) {
        	dto.setMrDistCode(null);
        }
        paramEntity.setMrDistCode(dto.getMrDistCode());

        //領域コード(MR)
        if (StringUtils.isEmpty(dto.getMrTrtCd())) {
        	dto.setMrTrtCd(null);
        }
        paramEntity.setMrTrtCd(dto.getMrTrtCd());

        //検索条件_氏名漢字(全角)
        if (StringUtils.isEmpty(dto.getKensakuDocKanj())) {
        	dto.setKensakuDocKanj(null);
        }
        paramEntity.setKensakuDocKanj(dto.getKensakuDocKanj());

        //検索条件_氏名カナ(半角カナ)
        if (StringUtils.isEmpty(dto.getKensakuDocKana())) {
        	dto.setKensakuDocKana(null);
        }
        paramEntity.setKensakuDocKana(dto.getKensakuDocKana());

        //検索条件_医師／薬剤師区分
        if (StringUtils.isEmpty(dto.getKensakuDocType())) {
        	dto.setKensakuDocType(null);
        }
        paramEntity.setKensakuDocType(dto.getKensakuDocType());

        //検索条件_医師固定C
        if (StringUtils.isEmpty(dto.getKensakuDocNo())) {
        	dto.setKensakuDocNo(null);
        }
        paramEntity.setKensakuDocNo(dto.getKensakuDocNo());

        //検索条件_ULT医師コード
        if (StringUtils.isEmpty(dto.getKensakuUltDocNo())) {
        	dto.setKensakuUltDocNo(null);
        }
        paramEntity.setKensakuUltDocNo(dto.getKensakuUltDocNo());

        //検索条件_医師属性
        if (StringUtils.isEmpty(dto.getKensakuDocAttribute())) {
        	dto.setKensakuDocAttribute(null);
        }
        paramEntity.setKensakuDocAttribute(dto.getKensakuDocAttribute());

        //検索条件_出身校
        if (StringUtils.isEmpty(dto.getKensakuMedSch())) {
        	dto.setKensakuMedSch(null);
        }
        paramEntity.setKensakuMedSch(dto.getKensakuMedSch());

        //検索条件_卒年(西暦)
        if (StringUtils.isEmpty(dto.getKensakuGradYear())) {
        	dto.setKensakuGradYear(null);
        }
        paramEntity.setKensakuGradYear(dto.getKensakuGradYear());

        //検索条件_出身医局校
        if (StringUtils.isEmpty(dto.getKensakuHuniv())) {
        	dto.setKensakuHuniv(null);
        }
        paramEntity.setKensakuHuniv(dto.getKensakuHuniv());

        //検索条件_施設固定C
        if (StringUtils.isEmpty(dto.getKensakuInsNo())) {
        	dto.setKensakuInsNo(null);
        }
        paramEntity.setKensakuInsNo(dto.getKensakuInsNo());

        //検索条件_施設名
        if (StringUtils.isEmpty(dto.getKensakuInsKanj())) {
        	dto.setKensakuInsKanj(null);
        }
        paramEntity.setKensakuInsKanj(dto.getKensakuInsKanj());

        // SimpleDateFormatで日付フォーマット設定
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        //検索条件_更新日(FROM)
        if (dto.getKensakuUpdMstFrom().isEmpty()) {
        	dto.setKensakuUpdMstFrom(null);
        	paramEntity.setKensakuUpdMstFrom(null);
        }
        else {
            	dto.setUpdMstFrom(dto.getKensakuUpdMstFrom());
    			paramEntity.setKensakuUpdMstFrom(dto.getKensakuUpdMstFrom().replace("-", ""));
        }
        //検索条件_更新日(TO)
        if (dto.getKensakuUpdMstTo().isEmpty()) {
        	dto.setKensakuUpdMstTo(null);
        	paramEntity.setKensakuUpdMstTo(null);
        }
        else {
            	dto.setUpdMstTo(dto.getKensakuUpdMstTo());
    			paramEntity.setKensakuUpdMstTo(dto.getKensakuUpdMstTo().replace("-", ""));
        }

        //申請区分が'31'(医師新規作成),'41'(医師勤務先追加)_検索SQL
        paramEntity.setSqlId("searchKmuHst1");
        //申請区分が'31'(医師新規作成),'41'(医師勤務先追加)の帳票一覧を取得する
        List<MRdmHcpUpdHstListEntity> SelectHcoUpdHstList1 = dao.select(paramEntity);

        //申請区分が'51'(勤務先情報更新)、'42'(医療機関への異動)_検索SQL
        paramEntity.setSqlId("searchKmuHst2");
        //申請区分が'51'(勤務先情報更新)、'42'(医療機関への異動)の帳票一覧を取得する
        List<MRdmHcpUpdHstListEntity> SelectHcoUpdHstList2 = dao.select(paramEntity);

        //申請区分が'43'(医療機関以外への異動)
        paramEntity.setSqlId("searchKmuHst3");
        //申請区分が'43'(医療機関以外への異動)の帳票一覧を取得する
        List<MRdmHcpUpdHstListEntity> SelectHcoUpdHstList3 = dao.select(paramEntity);

        //申請区分が'44'(医師勤務先削除)_検索SQL
        paramEntity.setSqlId("searchKmuHst4");
        //申請区分が'44'(医師勤務先削除)の帳票一覧を取得する
        List<MRdmHcpUpdHstListEntity> SelectHcoUpdHstList4 = dao.select(paramEntity);

        //申請区分が'33'(医師削除)_検索SQL
        paramEntity.setSqlId("searchKmuHst5");
        //申請区分が'33'(医師削除)の帳票一覧を取得する
        List<MRdmHcpUpdHstListEntity> SelectHcoUpdHstList5 = dao.select(paramEntity);

        List<MRdmHcpUpdHstListEntity> SelectHcoUpdHstList = new ArrayList<>(SelectHcoUpdHstList1);
        SelectHcoUpdHstList.addAll(SelectHcoUpdHstList2);
        SelectHcoUpdHstList.addAll(SelectHcoUpdHstList3);
        SelectHcoUpdHstList.addAll(SelectHcoUpdHstList4);
        SelectHcoUpdHstList.addAll(SelectHcoUpdHstList5);

        //検索結果が0件の場合
        if (CollectionUtils.isEmpty(SelectHcoUpdHstList)) {
        	paramEntity.setInLimit(0);
        	return outdto;
        }

      // 件数定義取得
		SelectParamND501Entity selectParamND501Entity = new SelectParamND501Entity();
		List<SelectParamND501Entity> selectParamND501List;
		selectParamND501List = dao.select(selectParamND501Entity);

	    //検索結果が上限以上の場合
	    if (SelectHcoUpdHstList.size() > selectParamND501List.get(0).getValue()) {
	    	dto.setKensakuBool(false);
    		return outdto;
	    }

	    dto.initPageInfo(dto.getPageCntCur(), SelectHcoUpdHstList.size(), selectParamND501List.get(1).getValue());
        paramEntity.setInOffset(dto.getLineCntStart() - 1);
        paramEntity.setInLimit(selectParamND501List.get(1).getValue());

        paramEntity.setSqlId("searchKmuHst");
        SelectHcoUpdHstList = dao.select(paramEntity);

	    //検索結果画面受け渡し用リスト
	    List<HcpUpdHstDataList> hcoUpdHstDataList = new ArrayList<HcpUpdHstDataList>();

        //申請区分_生成用エンティティ
    	MRdmCodeMstEntity paramReqType = new MRdmCodeMstEntity();
    	//検索条件_申請区分
    	paramReqType.setCodeName("REQ_KBN");
        //申請区分の帳票一覧を取得する
        List<MRdmCodeMstEntity> SelectParamReqType = dao.selectByValue(paramReqType);

        //勤務形態_生成用エンティティ
    	MRdmCodeMstEntity paramJobForm = new MRdmCodeMstEntity();
    	//検索条件_勤務形態
    	paramJobForm.setCodeName("JOB_FORM");
        //勤務形態の帳票一覧を取得する
        List<MRdmCodeMstEntity> SelectParamJobForm = dao.selectByValue(paramJobForm);

        //申請チャネル_生成用エンティティ
    	MRdmCodeMstEntity paramReqChl = new MRdmCodeMstEntity();
    	//検索条件_申請チャネル
    	paramReqChl.setCodeName("REQ_CHL");
        //申請チャネルの帳票一覧を取得する
        List<MRdmCodeMstEntity> SelectparamReqChlList = dao.selectByValue(paramReqChl);

     	//薬審メンバー区分_生成用エンティティ
    	MRdmCodeMstEntity paramDcc = new MRdmCodeMstEntity();
    	//検索条件_薬審メンバー区分
    	paramDcc.setCodeName("DCC");
        //薬審メンバー区分の帳票一覧を取得する
        List<MRdmCodeMstEntity> SelectParamDcc = dao.selectByValue(paramDcc);

        //役職
        MRdmHcpYakusyokuEntity yakusyoku = new MRdmHcpYakusyokuEntity();
        yakusyoku.setUnivTitleFlg("0");
        yakusyoku.setDelFlg("0");
        List<MRdmHcpYakusyokuEntity> SelectParamYakusyoku = dao.select(yakusyoku);

        //大学職位
        MRdmHcpYakusyokuEntity univYakusyoku = new MRdmHcpYakusyokuEntity();
        univYakusyoku.setUnivTitleFlg("1");
        univYakusyoku.setDelFlg("0");
        List<MRdmHcpYakusyokuEntity> SelectParamUnivYakusyoku = dao.select(univYakusyoku);

        //医師_公的機関マスタ_生成用エンティティ
        MRdmHcpPubInstitutionEntity paramPubInstitution = new MRdmHcpPubInstitutionEntity();
        //医師_公的機関マスタの帳票一覧を取得する
        List<MRdmHcpPubInstitutionEntity> SelectParamPubInstitution = dao.selectByValue(paramPubInstitution);



        for (MRdmHcpUpdHstListEntity entity : SelectHcoUpdHstList) {
        	HcpUpdHstDataList dataRecord = new HcpUpdHstDataList();

        	if (!StringUtils.isEmpty(entity.getUpdMstYmd())) {//マスタ更新日
        		String yyyy = entity.getUpdMstYmd().substring(0,4);
        		String mm = entity.getUpdMstYmd().substring(4,6);
        		String dd = entity.getUpdMstYmd().substring(6,8);
        		entity.setUpdMstYmd(yyyy + "/" + mm + "/" + dd);
        	}
            dataRecord.setUpdMstYmd(entity.getUpdMstYmd());//マスタ更新日
            dataRecord.setDocNo(entity.getDocNo());//医師固定コード
            dataRecord.setDocKanj(entity.getDocKanj());//氏名（漢字)

            if (Objects.equals(entity.getReqType(), "43")) {//申請区分が'43'(医療機関以外への異動)
            	dataRecord.setInsNoSk(entity.getInsNoSk());//施設固定コード(異動先)
                dataRecord.setJobFormAf("--なし--");//勤務形態(異動先)
                dataRecord.setDeptKanjiAf("--なし--");//所属部科名（漢字）(異動先)
                dataRecord.setTitleCodeAf("--なし--");//役職コード(異動先)
                dataRecord.setUnivPosCodeAf("--なし--");//大学職位コード(異動先)
                dataRecord.setDccTypeAf("--なし--");//薬審メンバー区分(異動先)
            }
            else if (Objects.equals(entity.getReqType(), "33")) {//申請区分が'33'(医師削除)
            	dataRecord.setInsNoSk("廃業・死亡");//施設固定コード(異動先)
            	dataRecord.setJobFormAf("--なし--");//勤務形態(異動先)
                dataRecord.setDeptKanjiAf("--なし--");//所属部科名（漢字）(異動先)
                dataRecord.setTitleCodeAf("--なし--");//役職コード(異動先)
                dataRecord.setUnivPosCodeAf("--なし--");//大学職位コード(異動先)
                dataRecord.setDccTypeAf("--なし--");//薬審メンバー区分(異動先)
            }
            else {//その他
            	//施設固定コード(異動先)
            	if (!StringUtils.isEmpty(entity.getInsNoSk())) {
                	//医師_所属部科マスタ
                	MRdmHcpUpdHstListEntity shisetu = new MRdmHcpUpdHstListEntity();
                	shisetu.setHenkanInsNo(entity.getInsNoSk());
                	shisetu.setSqlId("selectInsAbbrName");
                	List<MRdmHcpUpdHstListEntity> SelectmShisetu = dao.select(shisetu);
                	if (!CollectionUtils.isEmpty(SelectmShisetu)) {
                		entity.setInsNoSk(SelectmShisetu.get(0).getInsAbbrName());
                	}
                }
            	dataRecord.setInsNoSk(entity.getInsNoSk());//施設固定コード(異動先)
                //勤務形態(異動先)
                if (!StringUtils.isEmpty(entity.getJobFormAf())) {
                	for (MRdmCodeMstEntity paramKinmuJobForm : SelectParamJobForm) {
                		if (Objects.deepEquals(entity.getJobFormAf(), paramKinmuJobForm.getValue1())) {
                			entity.setJobFormAf(paramKinmuJobForm.getValue1Kanj());
                			break;
                		}
                	}
                }
                dataRecord.setJobFormAf(entity.getJobFormAf());//勤務形態(異動先)

                dataRecord.setDeptKanjiAf(entity.getDeptKanjiAf());//所属部科名（漢字）(異動先)
                //役職コード(異動先)
                if (!StringUtils.isEmpty(entity.getTitleCodeAf())) {
                	for (MRdmHcpYakusyokuEntity paramYakusyoku : SelectParamYakusyoku) {
                		if (Objects.deepEquals(entity.getTitleCodeAf(), paramYakusyoku.getTitleCode())) {
                			entity.setTitleCodeAf(paramYakusyoku.getTitleKj());
                			break;
                		}
                	}
                }
                dataRecord.setTitleCodeAf(entity.getTitleCodeAf());//役職コード(異動先)

                //大学職位コード(異動先)
                if (!StringUtils.isEmpty(entity.getUnivPosCodeAf())) {
                	for (MRdmHcpYakusyokuEntity paramUnivYakusyoku : SelectParamUnivYakusyoku) {
                		if (Objects.deepEquals(entity.getUnivPosCodeAf(), paramUnivYakusyoku.getTitleCode())) {
                			entity.setUnivPosCodeAf(paramUnivYakusyoku.getTitleKj());
                			break;
                		}
                	}
                }
                dataRecord.setUnivPosCodeAf(entity.getUnivPosCodeAf());//大学職位コード(異動先)

                //薬審メンバー区分(異動先)
                if (!StringUtils.isEmpty(entity.getDccTypeAf())) {
                	for (MRdmCodeMstEntity paramKinmuDcc : SelectParamDcc) {
                		if (Objects.deepEquals(entity.getDccTypeAf(), paramKinmuDcc.getValue1())) {
                			entity.setDccTypeAf(paramKinmuDcc.getValue1Kanj());
                			break;
                		}
                	}
                }
                dataRecord.setDccTypeAf(entity.getDccTypeAf());//薬審メンバー区分(異動先)

                dataRecord.setInsNoSkUpdFlg(entity.getInsNoSkUpdFlg());//施設固定コード(異動先)更新フラグ
                dataRecord.setJobFormAfUpdFlg(entity.getJobFormAfUpdFlg());//勤務形態(異動先)更新フラグ
                dataRecord.setDeptKanjiAfUpdFlg(entity.getDeptKanjiAfUpdFlg());//所属部科名（漢字）(異動先)更新フラグ
                dataRecord.setTitleCodeAfUpdFlg(entity.getTitleCodeAfUpdFlg());//役職コード(異動先)更新フラグ
                dataRecord.setUnivPosCodeAfUpdFlg(entity.getUnivPosCodeAfUpdFlg());//大学職位コード(異動先)更新フラグ
                dataRecord.setDccTypeAfUpdFlg(entity.getDccTypeAfUpdFlg());//薬審メンバー区分(異動先)更新フラグ
            }

            //施設固定コード(異動元)
            if (!StringUtils.isEmpty(entity.getInsNoMt())) {
            	//医師_所属部科マスタ
            	MRdmHcpUpdHstListEntity shisetu = new MRdmHcpUpdHstListEntity();
            	shisetu.setHenkanInsNo(entity.getInsNoMt());
            	shisetu.setSqlId("selectInsAbbrName");
            	List<MRdmHcpUpdHstListEntity> SelectmShisetu = dao.select(shisetu);
            	entity.setInsNoMt(SelectmShisetu.get(0).getInsAbbrName());
            }
            dataRecord.setInsNoMt(entity.getInsNoMt());//施設固定コード(異動元)
            //勤務形態(異動元)
            if (!StringUtils.isEmpty(entity.getJobFormBf())) {
            	for (MRdmCodeMstEntity paramKinmuJobForm : SelectParamJobForm) {
            		if (Objects.deepEquals(entity.getJobFormBf(), paramKinmuJobForm.getValue1())) {
            			entity.setJobFormBf(paramKinmuJobForm.getValue1Kanj());
            			break;
            		}
            	}
            }
            dataRecord.setJobFormBf(entity.getJobFormBf());//勤務形態(異動元)

            dataRecord.setDeptKanjiBf(entity.getDeptKanjiBf());//所属部科名（漢字）(異動元)

            //役職コード(異動元)
            if (!StringUtils.isEmpty(entity.getTitleCodeBf())) {
            	for (MRdmHcpYakusyokuEntity paramYakusyoku : SelectParamYakusyoku) {
            		if (Objects.deepEquals(entity.getTitleCodeBf(), paramYakusyoku.getTitleCode())) {
            			entity.setTitleCodeBf(paramYakusyoku.getTitleKj());
            			break;
            		}
            	}
            }
            dataRecord.setTitleCodeBf(entity.getTitleCodeBf());//役職コード(異動元)

            //大学職位コード(異動元)
            if (!StringUtils.isEmpty(entity.getUnivPosCodeBf())) {
            	for (MRdmHcpYakusyokuEntity paramUnivYakusyoku : SelectParamUnivYakusyoku) {
            		if (Objects.deepEquals(entity.getUnivPosCodeBf(), paramUnivYakusyoku.getTitleCode())) {
            			entity.setUnivPosCodeBf(paramUnivYakusyoku.getTitleKj());
            			break;
            		}
            	}
            }
            dataRecord.setUnivPosCodeBf(entity.getUnivPosCodeBf());//大学職位コード(異動元)

            //薬審メンバー区分(異動元)
            if (!StringUtils.isEmpty(entity.getDccTypeBf())) {
            	for (MRdmCodeMstEntity paramKinmuDcc : SelectParamDcc) {
            		if (Objects.deepEquals(entity.getDccTypeBf(), paramKinmuDcc.getValue1())) {
            			entity.setDccTypeBf(paramKinmuDcc.getValue1Kanj());
            			break;
            		}
            	}
            }
            dataRecord.setDccTypeBf(entity.getDccTypeBf());//薬審メンバー区分(異動元)

            dataRecord.setReqShz(entity.getReqShz());//申請者所属
            dataRecord.setReqJgiName(entity.getReqJgiName());//申請者氏名
            dataRecord.setAprShz(entity.getAprShz());//承認者所属
            dataRecord.setAprShaId(entity.getAprShaId());//承認者氏名

            //申請区分
            if (!StringUtils.isEmpty(entity.getReqType())) {
            	for (MRdmCodeMstEntity paramKinmuReqType : SelectParamReqType) {
            		if (Objects.deepEquals(entity.getReqType(), paramKinmuReqType.getValue1())) {
            			entity.setReqType(paramKinmuReqType.getValue1Kanj());
            			break;
            		}
            	}
            }
            dataRecord.setReqType(entity.getReqType());//申請区分
            //申請チャネル
            if (!StringUtils.isEmpty(entity.getReqChl())) {
            	for (MRdmCodeMstEntity paramReqChlList : SelectparamReqChlList) {
            		if (Objects.deepEquals(entity.getReqChl(), paramReqChlList.getValue1())) {
            			entity.setReqChl(paramReqChlList.getValue1Kanj());
            			break;
            		}
            	}
            }
            dataRecord.setReqChl(entity.getReqChl());//申請チャネル

            dataRecord.setReqId(entity.getReqId());//申請ID

            //リストにデータ追加
            hcoUpdHstDataList.add(dataRecord);
        }

        //検索された帳票一覧をDTOに設定する
        dto.setHcpUpdHstDataList(hcoUpdHstDataList);

        return dto;
    }

    /**
     * 公的機関 検索処理
     * @param dto ND501DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO searchPublicHst(ND501DTO dto) {
        BaseDTO outdto = dto;

        //公的機関_検索件数取得の検索条件の設定
        MRdmHcpUpdHstListEntity paramEntity = new MRdmHcpUpdHstListEntity();

      //条件セット
        paramEntity.setJokenSetCd(dto.getJokenSetCd());
      //検索条件_従業員番号(管理者)
        if (StringUtils.isEmpty(dto.getKensakuJgiNo())) {
        	dto.setKensakuJgiNo(0);
        }
        paramEntity.setKensakuJgiNo(dto.getKensakuJgiNo());

        //検索条件_医薬支店C_申請者所属リージョン(管理者)
        if (StringUtils.isEmpty(dto.getKensakuShinseiBrCode())) {
        	dto.setKensakuShinseiBrCode(null);
        }
        paramEntity.setKensakuShinseiBrCode(dto.getKensakuShinseiBrCode());

        //検索条件_医薬営業所C_申請者所属エリア(管理者)
        if (StringUtils.isEmpty(dto.getKensakuShinseiDistCode())) {
        	dto.setKensakuShinseiDistCode(null);
        }
        paramEntity.setKensakuShinseiDistCode(dto.getKensakuShinseiDistCode());

        //検索条件_医薬支店C_担当者所属リージョン(管理者)
        if (StringUtils.isEmpty(dto.getKensakuSTantouBrCode())) {
        	dto.setKensakuSTantouBrCode(null);
        }
        paramEntity.setKensakuSTantouBrCode(dto.getKensakuSTantouBrCode());

        //検索条件_医薬営業所C_担当者所属エリア(管理者)
        if (StringUtils.isEmpty(dto.getKensakuTantouDistCode())) {
        	dto.setKensakuTantouDistCode(null);
        }
        paramEntity.setKensakuTantouDistCode(dto.getKensakuTantouDistCode());

        //検索条件_申請者(管理者)
        if (StringUtils.isEmpty(dto.getKensakuReqJgiName())) {
        	dto.setKensakuReqJgiName(null);
        }
        paramEntity.setKensakuReqJgiName(dto.getKensakuReqJgiName());

        //従業員番号(MR)
        if (StringUtils.isEmpty(dto.getMrJgiNo())) {
        	dto.setMrJgiNo(0);
        }
        paramEntity.setMrJgiNo(dto.getMrJgiNo());

        //医薬支店C_申請者所属リージョン(MR)
        if (StringUtils.isEmpty(dto.getMrBrCode())) {
        	dto.setMrBrCode(null);
        }
        paramEntity.setMrBrCode(dto.getMrBrCode());

        //医薬営業所C_申請者所属エリア(MR)
        if (StringUtils.isEmpty(dto.getMrDistCode())) {
        	dto.setMrDistCode(null);
        }
        paramEntity.setMrDistCode(dto.getMrDistCode());

        //領域コード(MR)
        if (StringUtils.isEmpty(dto.getMrTrtCd())) {
        	dto.setMrTrtCd(null);
        }
        paramEntity.setMrTrtCd(dto.getMrTrtCd());

        //検索条件_氏名漢字(全角)
        if (StringUtils.isEmpty(dto.getKensakuDocKanj())) {
        	dto.setKensakuDocKanj(null);
        }
        paramEntity.setKensakuDocKanj(dto.getKensakuDocKanj());

        //検索条件_氏名カナ(半角カナ)
        if (StringUtils.isEmpty(dto.getKensakuDocKana())) {
        	dto.setKensakuDocKana(null);
        }
        paramEntity.setKensakuDocKana(dto.getKensakuDocKana());

        //検索条件_医師／薬剤師区分
        if (StringUtils.isEmpty(dto.getKensakuDocType())) {
        	dto.setKensakuDocType(null);
        }
        paramEntity.setKensakuDocType(dto.getKensakuDocType());

        //検索条件_医師固定C
        if (StringUtils.isEmpty(dto.getKensakuDocNo())) {
        	dto.setKensakuDocNo(null);
        }
        paramEntity.setKensakuDocNo(dto.getKensakuDocNo());

        //検索条件_ULT医師コード
        if (StringUtils.isEmpty(dto.getKensakuUltDocNo())) {
        	dto.setKensakuUltDocNo(null);
        }
        paramEntity.setKensakuUltDocNo(dto.getKensakuUltDocNo());

        //検索条件_医師属性
        if (StringUtils.isEmpty(dto.getKensakuDocAttribute())) {
        	dto.setKensakuDocAttribute(null);
        }
        paramEntity.setKensakuDocAttribute(dto.getKensakuDocAttribute());

        //検索条件_出身校
        if (StringUtils.isEmpty(dto.getKensakuMedSch())) {
        	dto.setKensakuMedSch(null);
        }
        paramEntity.setKensakuMedSch(dto.getKensakuMedSch());

        //検索条件_卒年(西暦)
        if (StringUtils.isEmpty(dto.getKensakuGradYear())) {
        	dto.setKensakuGradYear(null);
        }
        paramEntity.setKensakuGradYear(dto.getKensakuGradYear());

        //検索条件_出身医局校
        if (StringUtils.isEmpty(dto.getKensakuHuniv())) {
        	dto.setKensakuHuniv(null);
        }
        paramEntity.setKensakuHuniv(dto.getKensakuHuniv());

        //検索条件_施設固定C
        if (StringUtils.isEmpty(dto.getKensakuInsNo())) {
        	dto.setKensakuInsNo(null);
        }
        paramEntity.setKensakuInsNo(dto.getKensakuInsNo());

        //検索条件_施設名
        if (StringUtils.isEmpty(dto.getKensakuInsKanj())) {
        	dto.setKensakuInsKanj(null);
        }
        paramEntity.setKensakuInsKanj(dto.getKensakuInsKanj());

        //検索条件_更新日(FROM)
        if (dto.getKensakuUpdMstFrom().isEmpty()) {
        	dto.setKensakuUpdMstFrom(null);
        	paramEntity.setKensakuUpdMstFrom(null);
        }
        else {
            	dto.setUpdMstFrom(dto.getKensakuUpdMstFrom());
    			paramEntity.setKensakuUpdMstFrom(dto.getKensakuUpdMstFrom().replace("-", ""));
        }
        //検索条件_更新日(TO)
        if (dto.getKensakuUpdMstTo().isEmpty()) {
        	dto.setKensakuUpdMstTo(null);
        	paramEntity.setKensakuUpdMstTo(null);
        }
        else {
            	dto.setUpdMstTo(dto.getKensakuUpdMstTo());
    			paramEntity.setKensakuUpdMstTo(dto.getKensakuUpdMstTo().replace("-", ""));
        }
        //公的機関_検索SQL
        paramEntity.setSqlId("searchPublicHst");

        //画面初期表示時の帳票一覧を取得する
        List<MRdmHcpUpdHstListEntity> SelectHcoUpdHstList = dao.select(paramEntity);

        //検索結果が0件の場合
        if (CollectionUtils.isEmpty(SelectHcoUpdHstList)) {
        	paramEntity.setInLimit(0);
        	return outdto;
        }

      // 件数定義取得
		SelectParamND501Entity selectParamND501Entity = new SelectParamND501Entity();
		List<SelectParamND501Entity> selectParamND501List;
		selectParamND501List = dao.select(selectParamND501Entity);

	    //検索結果が上限以上の場合
	    if (SelectHcoUpdHstList.size() > selectParamND501List.get(0).getValue()) {
	    	dto.setKensakuBool(false);
    		return outdto;
	    }

	    dto.initPageInfo(dto.getPageCntCur(), SelectHcoUpdHstList.size(), selectParamND501List.get(1).getValue());
        paramEntity.setInOffset(dto.getLineCntStart() - 1);
        paramEntity.setInLimit(selectParamND501List.get(1).getValue());
        SelectHcoUpdHstList = dao.select(paramEntity);

	    //検索結果画面受け渡し用リスト
	    List<HcpUpdHstDataList> hcoUpdHstDataList = new ArrayList<HcpUpdHstDataList>();

        //分類区分_生成用エンティティ
    	MRdmCodeMstEntity paramClassCategory = new MRdmCodeMstEntity();
    	//検索条件_分類区分
    	paramClassCategory.setCodeName("CLASS_CATEGORY");
        //分類区分の帳票一覧を取得する
        List<MRdmCodeMstEntity> SelectParamClassCategory = dao.selectByValue(paramClassCategory);

        //所属役職_生成用エンティティ
    	MRdmCodeMstEntity paramPositionCode = new MRdmCodeMstEntity();
    	//検索条件_所属役職
    	paramPositionCode.setCodeName("POSITION_CODE");
        //所属役職の帳票一覧を取得する
        List<MRdmCodeMstEntity> SelectparamPositionCode = dao.selectByValue(paramPositionCode);

        //医師_公的機関マスタ_生成用エンティティ
        MRdmHcpPubInstitutionEntity paramPubInstitution = new MRdmHcpPubInstitutionEntity();
        //医師_公的機関マスタの帳票一覧を取得する
        List<MRdmHcpPubInstitutionEntity> SelectParamPubInstitution = dao.selectByValue(paramPubInstitution);

        //申請チャネル_生成用エンティティ
    	MRdmCodeMstEntity paramReqChl = new MRdmCodeMstEntity();
    	//検索条件_申請チャネル
    	paramReqChl.setCodeName("REQ_CHL");
        //申請チャネルの帳票一覧を取得する
        List<MRdmCodeMstEntity> SelectparamReqChlList = dao.selectByValue(paramReqChl);

        for (MRdmHcpUpdHstListEntity entity : SelectHcoUpdHstList) {
        	HcpUpdHstDataList dataRecord = new HcpUpdHstDataList();

        	if (!StringUtils.isEmpty(entity.getUpdMstYmd())) {//マスタ更新日
        		String yyyy = entity.getUpdMstYmd().substring(0,4);
        		String mm = entity.getUpdMstYmd().substring(4,6);
        		String dd = entity.getUpdMstYmd().substring(6,8);
        		entity.setUpdMstYmd(yyyy + "/" + mm + "/" + dd);
        	}
            dataRecord.setUpdMstYmd(entity.getUpdMstYmd());//マスタ更新日
            dataRecord.setDocNo(entity.getDocNo());//医師固定コード
            dataRecord.setDocKanj(entity.getDocKanj());//氏名（漢字)

            //分類区分
            if (!StringUtils.isEmpty(entity.getClassCateGory())) {
            	for (MRdmCodeMstEntity paramKoutekiClassCategory : SelectParamClassCategory) {
            		if (Objects.deepEquals(entity.getClassCateGory(), paramKoutekiClassCategory.getValue1())) {
            			entity.setClassCateGory(paramKoutekiClassCategory.getValue1Kanj());
            			break;
            		}
            	}
            }
            dataRecord.setClassCateGory(entity.getClassCateGory());//分類区分
            dataRecord.setClassCateGoryUpdFlg(entity.getClassCateGoryUpdFlg());//分類区分更新フラグ
            //公的機関
//            if (!StringUtils.isEmpty(entity.getPubInstitution())) {
//            	for (MRdmHcpPubInstitutionEntity paramKoutekiPubInstitution : SelectParamPubInstitution) {
//            		if (Objects.deepEquals(entity.getPubInstitution(), paramKoutekiPubInstitution.getPubInstitutionCd())) {
//            			entity.setPubInstitution(paramKoutekiPubInstitution.getPubInstitutionCd());
//            			break;
//            		}
//            	}
//            }
            dataRecord.setPubInstitution(entity.getPubInstitution());//公的機関

            dataRecord.setPubInstitutionUpdFlg(entity.getPubInstitutionUpdFlg());//公的機関更新フラグ
            dataRecord.setPubInstStYmd(setFmtYmd(entity.getPubInstStYmd()));//公的機関開始年月日
            dataRecord.setPubInstStYmdUpdFlg(entity.getPubInstStYmdUpdFlg());//公的機関開始年月日更新フラグ
            dataRecord.setPubInstEdYmd(setFmtYmd(entity.getPubInstEdYmd()));//公的機関終了年月日
            dataRecord.setPubInstEdYmdUpdFlg(entity.getPubInstEdYmdUpdFlg());//公的機関終了年月日更新フラグ
            //公的機関役職コード
            if (!StringUtils.isEmpty(entity.getPubInstPosition())) {
            	for (MRdmCodeMstEntity paramKoutekiPositionCode : SelectparamPositionCode) {
            		if (Objects.deepEquals(entity.getPubInstPosition(), paramKoutekiPositionCode.getValue1())) {
            			entity.setPubInstPosition(paramKoutekiPositionCode.getValue1Kanj());
            			break;
            		}
            	}
            }
            dataRecord.setPubInstPosition(entity.getPubInstPosition());//公的機関役職コード//分類区分

            dataRecord.setPubInstPositionUpdFlg(entity.getPubInstPositionUpdFlg());//公的機関役職コード更新フラグ
            dataRecord.setPubInstposStYmd(setFmtYmd(entity.getPubInstposStYmd()));//公的機関役職開始年月日
            dataRecord.setPubInstposStYmdUpdFlg(entity.getPubInstposStYmdUpdFlg());//公的機関役職開始年月日更新フラグ
            dataRecord.setPubInstposEdYmd(setFmtYmd(entity.getPubInstposEdYmd()));//公的機関役職終了年月日
            dataRecord.setPubInstposEdYmdUpdFlg(entity.getPubInstposEdYmdUpdFlg());//公的機関役職終了年月日更新フラグ

            dataRecord.setReqShz(entity.getReqShz());//申請者所属
            dataRecord.setReqJgiName(entity.getReqJgiName());//申請者氏名
            dataRecord.setAprShz(entity.getAprShz());//承認者所属
            dataRecord.setAprShaId(entity.getAprShaId());//承認者氏名
            //申請チャネル
            if (!StringUtils.isEmpty(entity.getReqChl())) {
            	for (MRdmCodeMstEntity paramReqChlList : SelectparamReqChlList) {
            		if (Objects.deepEquals(entity.getReqChl(), paramReqChlList.getValue1())) {
            			entity.setReqChl(paramReqChlList.getValue1Kanj());
            			break;
            		}
            	}
            }
            dataRecord.setReqChl(entity.getReqChl());//申請チャネル

            dataRecord.setReqId(entity.getReqId());//申請ID

            //リストにデータ追加
            hcoUpdHstDataList.add(dataRecord);
        }

        //検索された帳票一覧をDTOに設定する
        dto.setHcpUpdHstDataList(hcoUpdHstDataList);

        return dto;
    }

    /**
     * 所属学会 検索処理
     * @param dto ND501DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO searchHcpSociety(ND501DTO dto) {
        BaseDTO outdto = dto;

        //所属学会_検索件数取得の検索条件の設定
        MRdmHcpUpdHstListEntity paramEntity = new MRdmHcpUpdHstListEntity();
      //条件セット
        paramEntity.setJokenSetCd(dto.getJokenSetCd());

      //検索条件_従業員番号(管理者)
        if (StringUtils.isEmpty(dto.getKensakuJgiNo())) {
        	dto.setKensakuJgiNo(0);
        }
        paramEntity.setKensakuJgiNo(dto.getKensakuJgiNo());

        //検索条件_医薬支店C_申請者所属リージョン(管理者)
        if (StringUtils.isEmpty(dto.getKensakuShinseiBrCode())) {
        	dto.setKensakuShinseiBrCode(null);
        }
        paramEntity.setKensakuShinseiBrCode(dto.getKensakuShinseiBrCode());

        //検索条件_医薬営業所C_申請者所属エリア(管理者)
        if (StringUtils.isEmpty(dto.getKensakuShinseiDistCode())) {
        	dto.setKensakuShinseiDistCode(null);
        }
        paramEntity.setKensakuShinseiDistCode(dto.getKensakuShinseiDistCode());

        //検索条件_医薬支店C_担当者所属リージョン(管理者)
        if (StringUtils.isEmpty(dto.getKensakuSTantouBrCode())) {
        	dto.setKensakuSTantouBrCode(null);
        }
        paramEntity.setKensakuSTantouBrCode(dto.getKensakuSTantouBrCode());

        //検索条件_医薬営業所C_担当者所属エリア(管理者)
        if (StringUtils.isEmpty(dto.getKensakuTantouDistCode())) {
        	dto.setKensakuTantouDistCode(null);
        }
        paramEntity.setKensakuTantouDistCode(dto.getKensakuTantouDistCode());

        //検索条件_申請者(管理者)
        if (StringUtils.isEmpty(dto.getKensakuReqJgiName())) {
        	dto.setKensakuReqJgiName(null);
        }
        paramEntity.setKensakuReqJgiName(dto.getKensakuReqJgiName());

        //従業員番号(MR)
        if (StringUtils.isEmpty(dto.getMrJgiNo())) {
        	dto.setMrJgiNo(0);
        }
        paramEntity.setMrJgiNo(dto.getMrJgiNo());

        //医薬支店C_申請者所属リージョン(MR)
        if (StringUtils.isEmpty(dto.getMrBrCode())) {
        	dto.setMrBrCode(null);
        }
        paramEntity.setMrBrCode(dto.getMrBrCode());

        //医薬営業所C_申請者所属エリア(MR)
        if (StringUtils.isEmpty(dto.getMrDistCode())) {
        	dto.setMrDistCode(null);
        }
        paramEntity.setMrDistCode(dto.getMrDistCode());

        //領域コード(MR)
        if (StringUtils.isEmpty(dto.getMrTrtCd())) {
        	dto.setMrTrtCd(null);
        }
        paramEntity.setMrTrtCd(dto.getMrTrtCd());

        //検索条件_氏名漢字(全角)
        if (StringUtils.isEmpty(dto.getKensakuDocKanj())) {
        	dto.setKensakuDocKanj(null);
        }
        paramEntity.setKensakuDocKanj(dto.getKensakuDocKanj());

        //検索条件_氏名カナ(半角カナ)
        if (StringUtils.isEmpty(dto.getKensakuDocKana())) {
        	dto.setKensakuDocKana(null);
        }
        paramEntity.setKensakuDocKana(dto.getKensakuDocKana());

        //検索条件_医師／薬剤師区分
        if (StringUtils.isEmpty(dto.getKensakuDocType())) {
        	dto.setKensakuDocType(null);
        }
        paramEntity.setKensakuDocType(dto.getKensakuDocType());

        //検索条件_医師固定C
        if (StringUtils.isEmpty(dto.getKensakuDocNo())) {
        	dto.setKensakuDocNo(null);
        }
        paramEntity.setKensakuDocNo(dto.getKensakuDocNo());

        //検索条件_ULT医師コード
        if (StringUtils.isEmpty(dto.getKensakuUltDocNo())) {
        	dto.setKensakuUltDocNo(null);
        }
        paramEntity.setKensakuUltDocNo(dto.getKensakuUltDocNo());

        //検索条件_医師属性
        if (StringUtils.isEmpty(dto.getKensakuDocAttribute())) {
        	dto.setKensakuDocAttribute(null);
        }
        paramEntity.setKensakuDocAttribute(dto.getKensakuDocAttribute());

        //検索条件_出身校
        if (StringUtils.isEmpty(dto.getKensakuMedSch())) {
        	dto.setKensakuMedSch(null);
        }
        paramEntity.setKensakuMedSch(dto.getKensakuMedSch());

        //検索条件_卒年(西暦)
        if (StringUtils.isEmpty(dto.getKensakuGradYear())) {
        	dto.setKensakuGradYear(null);
        }
        paramEntity.setKensakuGradYear(dto.getKensakuGradYear());

        //検索条件_出身医局校
        if (StringUtils.isEmpty(dto.getKensakuHuniv())) {
        	dto.setKensakuHuniv(null);
        }
        paramEntity.setKensakuHuniv(dto.getKensakuHuniv());

        //検索条件_施設固定C
        if (StringUtils.isEmpty(dto.getKensakuInsNo())) {
        	dto.setKensakuInsNo(null);
        }
        paramEntity.setKensakuInsNo(dto.getKensakuInsNo());

        //検索条件_施設名
        if (StringUtils.isEmpty(dto.getKensakuInsKanj())) {
        	dto.setKensakuInsKanj(null);
        }
        paramEntity.setKensakuInsKanj(dto.getKensakuInsKanj());

        //検索条件_更新日(FROM)
        if (dto.getKensakuUpdMstFrom().isEmpty()) {
        	dto.setKensakuUpdMstFrom(null);
        	paramEntity.setKensakuUpdMstFrom(null);
        }
        else {
            	dto.setUpdMstFrom(dto.getKensakuUpdMstFrom());
    			paramEntity.setKensakuUpdMstFrom(dto.getKensakuUpdMstFrom().replace("-", ""));
        }
        //検索条件_更新日(TO)
        if (dto.getKensakuUpdMstTo().isEmpty()) {
        	dto.setKensakuUpdMstTo(null);
        	paramEntity.setKensakuUpdMstTo(null);
        }
        else {
            	dto.setUpdMstTo(dto.getKensakuUpdMstTo());
    			paramEntity.setKensakuUpdMstTo(dto.getKensakuUpdMstTo().replace("-", ""));
        }
        //所属学会_検索SQL
        paramEntity.setSqlId("searchHcpSociety");

        //画面初期表示時の帳票一覧を取得する
        List<MRdmHcpUpdHstListEntity> SelectHcoUpdHstList = dao.select(paramEntity);

        //検索結果が0件の場合
        if (CollectionUtils.isEmpty(SelectHcoUpdHstList)) {
        	paramEntity.setInLimit(0);
        	return outdto;
        }

      // 件数定義取得
		SelectParamND501Entity selectParamND501Entity = new SelectParamND501Entity();
		List<SelectParamND501Entity> selectParamND501List;
		selectParamND501List = dao.select(selectParamND501Entity);

	    //検索結果が上限以上の場合
	    if (SelectHcoUpdHstList.size() > selectParamND501List.get(0).getValue()) {
	    	dto.setKensakuBool(false);
    		return outdto;
	    }

	    dto.initPageInfo(dto.getPageCntCur(), SelectHcoUpdHstList.size(), selectParamND501List.get(1).getValue());
        paramEntity.setInOffset(dto.getLineCntStart() - 1);
        paramEntity.setInLimit(selectParamND501List.get(1).getValue());
        SelectHcoUpdHstList = dao.select(paramEntity);

	    //検索結果画面受け渡し用リスト
	    List<HcpUpdHstDataList> hcoUpdHstDataList = new ArrayList<HcpUpdHstDataList>();

        //所属役職_生成用エンティティ
    	MRdmCodeMstEntity paramPositionCode = new MRdmCodeMstEntity();
    	//検索条件_所属役職
    	paramPositionCode.setCodeName("POSITION_CODE");
        //所属役職の帳票一覧を取得する
        List<MRdmCodeMstEntity> SelectparamPositionCode = dao.selectByValue(paramPositionCode);

        //申請チャネル_生成用エンティティ
    	MRdmCodeMstEntity paramReqChl = new MRdmCodeMstEntity();
    	//検索条件_申請チャネル
    	paramReqChl.setCodeName("REQ_CHL");
        //申請チャネルの帳票一覧を取得する
        List<MRdmCodeMstEntity> SelectparamReqChlList = dao.selectByValue(paramReqChl);

        for (MRdmHcpUpdHstListEntity entity : SelectHcoUpdHstList) {
        	HcpUpdHstDataList dataRecord = new HcpUpdHstDataList();

        	if (!StringUtils.isEmpty(entity.getUpdMstYmd())) {//マスタ更新日
        		String yyyy = entity.getUpdMstYmd().substring(0,4);
        		String mm = entity.getUpdMstYmd().substring(4,6);
        		String dd = entity.getUpdMstYmd().substring(6,8);
        		entity.setUpdMstYmd(yyyy + "/" + mm + "/" + dd);
        	}
            dataRecord.setUpdMstYmd(entity.getUpdMstYmd());//マスタ更新日
            dataRecord.setDocNo(entity.getDocNo());//医師固定コード
            dataRecord.setDocKanj(entity.getDocKanj());//氏名（漢字)
            dataRecord.setMedicalSocietyNm(entity.getMedicalSocietyNm());//所属学会名称
            dataRecord.setMedicalSocietyNmUpdFlg(entity.getMedicalSocietyNmUpdFlg());//所属学会名称更新フラグ
            dataRecord.setAdmissionYmd(setFmtYmd(entity.getAdmissionYmd()));//入会日
            dataRecord.setAdmissionYmdUpdFlg(entity.getAdmissionYmdUpdFlg());//入会年月日更新フラグ
            dataRecord.setQuitYmd(setFmtYmd(entity.getQuitYmd()));//脱会日
            dataRecord.setQuitYmdUpdFlg(entity.getQuitYmdUpdFlg());//脱会年月日更新フラグ
            //所属役職
            if (!StringUtils.isEmpty(entity.getPositionCode())) {
            	for (MRdmCodeMstEntity paramPosition : SelectparamPositionCode) {
            		if (Objects.deepEquals(entity.getPositionCode(), paramPosition.getValue1())) {
            			entity.setPositionCode(paramPosition.getValue1Kanj());
            			break;
            		}
            	}
            }
            dataRecord.setPositionCode(entity.getPositionCode());

            dataRecord.setPositionCodeUpdFlg(entity.getPositionCodeUpdFlg());//所属役職更新フラグ
            dataRecord.setSocietyPosiStYmd(setFmtYmd(entity.getSocietyPosiStYmd()));//役職開始年月日
            dataRecord.setSocietyPosiStYmdUpdFlg(entity.getSocietyPosiStYmdUpdFlg());//役職開始年月日更新フラグ
            dataRecord.setSocietyPosiEdYmd(setFmtYmd(entity.getSocietyPosiEdYmd()));//役職終了年月日
            dataRecord.setSocietyPosiEdYmdUpdFlg(entity.getSocietyPosiEdYmdUpdFlg());//役職終了年月日更新フラグ
            dataRecord.setCoachingAcquisiYmd(setFmtYmd(entity.getCoachingAcquisiYmd()));//指導医取得年月日
            dataRecord.setCoachingAcquisiYmdUpdFlg(entity.getCoachingAcquisiYmdUpdFlg());//指導医取得年月日更新フラグ
            dataRecord.setCoachinStYmd(setFmtYmd(entity.getCoachinStYmd()));//指導医開始年月日
            dataRecord.setCoachinStYmdUpdFlg(entity.getCoachinStYmdUpdFlg());//指導医開始年月日更新フラグ
            dataRecord.setCoachinEdYmd(setFmtYmd(entity.getCoachinEdYmd()));//指導医終了年月日
            dataRecord.setCoachingEdYmdUpdFlg(entity.getCoachingEdYmdUpdFlg());//指導医終了年月日更新フラグ
            dataRecord.setCertifyStYmd(setFmtYmd(entity.getCertifyStYmd()));//認定医開始年月日
            dataRecord.setCertifyStYmdUpdFlg(entity.getCertifyStYmdUpdFlg());//認定医開始年月日更新フラグ
            dataRecord.setCertifyEdYmd(setFmtYmd(entity.getCertifyEdYmd()));//認定医終了年月日
            dataRecord.setCertifyEdYmdUpdFlg(entity.getCertifyEdYmdUpdFlg());//認定医終了年月日更新フラグ
            dataRecord.setAdvisingDoctor(entity.getAdvisingDoctor());//所属学会指導医区分
            dataRecord.setAdvisingDoctorUpdFlg(entity.getAdvisingDoctorUpdFlg());//所属学会指導医区分更新フラグ
            dataRecord.setCertifyingPhysician(entity.getCertifyingPhysician());//所属学会認定医区分
            dataRecord.setCertifyingPhysicianUpdFlg(entity.getCertifyingPhysicianUpdFlg());//所属学会認定医区分
            dataRecord.setReqShz(entity.getReqShz());//申請者所属
            dataRecord.setReqJgiName(entity.getReqJgiName());//申請者氏名
            dataRecord.setAprShz(entity.getAprShz());//承認者所属
            dataRecord.setAprShaId(entity.getAprShaId());//承認者氏名
            //申請チャネル
            if (!StringUtils.isEmpty(entity.getReqChl())) {
            	for (MRdmCodeMstEntity paramReqChlList : SelectparamReqChlList) {
            		if (Objects.deepEquals(entity.getReqChl(), paramReqChlList.getValue1())) {
            			entity.setReqChl(paramReqChlList.getValue1Kanj());
            			break;
            		}
            	}
            }
            dataRecord.setReqChl(entity.getReqChl());//申請チャネル

            dataRecord.setReqId(entity.getReqId());//申請ID

            //リストにデータ追加
            hcoUpdHstDataList.add(dataRecord);
        }

        //検索された帳票一覧をDTOに設定する
        dto.setHcpUpdHstDataList(hcoUpdHstDataList);

        return dto;
    }

    /**
     * 医師基本情報 検索処理
     * @param dto ND501DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO searchUpdHst(ND501DTO dto) {
        BaseDTO outdto = dto;

        //医師基本情報_検索件数取得の検索条件の設定
        MRdmHcpUpdHstListEntity paramEntity = new MRdmHcpUpdHstListEntity();

      //条件セット
        paramEntity.setJokenSetCd(dto.getJokenSetCd());

      //検索条件_従業員番号(管理者)
        if (StringUtils.isEmpty(dto.getKensakuJgiNo())) {
        	dto.setKensakuJgiNo(0);
        }
        paramEntity.setKensakuJgiNo(dto.getKensakuJgiNo());

        //検索条件_医薬支店C_申請者所属リージョン(管理者)
        if (StringUtils.isEmpty(dto.getKensakuShinseiBrCode())) {
        	dto.setKensakuShinseiBrCode(null);
        }
        paramEntity.setKensakuShinseiBrCode(dto.getKensakuShinseiBrCode());

        //検索条件_医薬営業所C_申請者所属エリア(管理者)
        if (StringUtils.isEmpty(dto.getKensakuShinseiDistCode())) {
        	dto.setKensakuShinseiDistCode(null);
        }
        paramEntity.setKensakuShinseiDistCode(dto.getKensakuShinseiDistCode());

        //検索条件_医薬支店C_担当者所属リージョン(管理者)
        if (StringUtils.isEmpty(dto.getKensakuSTantouBrCode())) {
        	dto.setKensakuSTantouBrCode(null);
        }
        paramEntity.setKensakuSTantouBrCode(dto.getKensakuSTantouBrCode());

        //検索条件_医薬営業所C_担当者所属エリア(管理者)
        if (StringUtils.isEmpty(dto.getKensakuTantouDistCode())) {
        	dto.setKensakuTantouDistCode(null);
        }
        paramEntity.setKensakuTantouDistCode(dto.getKensakuTantouDistCode());

        //検索条件_申請者(管理者)
        if (StringUtils.isEmpty(dto.getKensakuReqJgiName())) {
        	dto.setKensakuReqJgiName(null);
        }
        paramEntity.setKensakuReqJgiName(dto.getKensakuReqJgiName());

        //従業員番号(MR)
        if (StringUtils.isEmpty(dto.getMrJgiNo())) {
        	dto.setMrJgiNo(0);
        }
        paramEntity.setMrJgiNo(dto.getMrJgiNo());

        //医薬支店C_申請者所属リージョン(MR)
        if (StringUtils.isEmpty(dto.getMrBrCode())) {
        	dto.setMrBrCode(null);
        }
        paramEntity.setMrBrCode(dto.getMrBrCode());

        //医薬営業所C_申請者所属エリア(MR)
        if (StringUtils.isEmpty(dto.getMrDistCode())) {
        	dto.setMrDistCode(null);
        }
        paramEntity.setMrDistCode(dto.getMrDistCode());

        //領域コード(MR)
        if (StringUtils.isEmpty(dto.getMrTrtCd())) {
        	dto.setMrTrtCd(null);
        }
        paramEntity.setMrTrtCd(dto.getMrTrtCd());

        //検索条件_氏名漢字(全角)
        if (StringUtils.isEmpty(dto.getKensakuDocKanj())) {
        	dto.setKensakuDocKanj(null);
        }
        paramEntity.setKensakuDocKanj(dto.getKensakuDocKanj());

        //検索条件_氏名カナ(半角カナ)
        if (StringUtils.isEmpty(dto.getKensakuDocKana())) {
        	dto.setKensakuDocKana(null);
        }
        paramEntity.setKensakuDocKana(dto.getKensakuDocKana());

        //検索条件_医師／薬剤師区分
        if (StringUtils.isEmpty(dto.getKensakuDocType())) {
        	dto.setKensakuDocType(null);
        }
        paramEntity.setKensakuDocType(dto.getKensakuDocType());

        //検索条件_医師固定C
        if (StringUtils.isEmpty(dto.getKensakuDocNo())) {
        	dto.setKensakuDocNo(null);
        }
        paramEntity.setKensakuDocNo(dto.getKensakuDocNo());

        //検索条件_ULT医師コード
        if (StringUtils.isEmpty(dto.getKensakuUltDocNo())) {
        	dto.setKensakuUltDocNo(null);
        }
        paramEntity.setKensakuUltDocNo(dto.getKensakuUltDocNo());

        //検索条件_医師属性
        if (StringUtils.isEmpty(dto.getKensakuDocAttribute())) {
        	dto.setKensakuDocAttribute(null);
        }
        paramEntity.setKensakuDocAttribute(dto.getKensakuDocAttribute());

        //検索条件_出身校
        if (StringUtils.isEmpty(dto.getKensakuMedSch())) {
        	dto.setKensakuMedSch(null);
        }
        paramEntity.setKensakuMedSch(dto.getKensakuMedSch());

        //検索条件_卒年(西暦)
        if (StringUtils.isEmpty(dto.getKensakuGradYear())) {
        	dto.setKensakuGradYear(null);
        }
        paramEntity.setKensakuGradYear(dto.getKensakuGradYear());

        //検索条件_出身医局校
        if (StringUtils.isEmpty(dto.getKensakuHuniv())) {
        	dto.setKensakuHuniv(null);
        }
        paramEntity.setKensakuHuniv(dto.getKensakuHuniv());

        //検索条件_施設固定C
        if (StringUtils.isEmpty(dto.getKensakuInsNo())) {
        	dto.setKensakuInsNo(null);
        }
        paramEntity.setKensakuInsNo(dto.getKensakuInsNo());

        //検索条件_施設名
        if (StringUtils.isEmpty(dto.getKensakuInsKanj())) {
        	dto.setKensakuInsKanj(null);
        }
        paramEntity.setKensakuInsKanj(dto.getKensakuInsKanj());

      //検索条件_更新日(FROM)
        if (dto.getKensakuUpdMstFrom().isEmpty()) {
        	dto.setKensakuUpdMstFrom(null);
        	paramEntity.setKensakuUpdMstFrom(null);
        }
        else {
            	dto.setUpdMstFrom(dto.getKensakuUpdMstFrom());
    			paramEntity.setKensakuUpdMstFrom(dto.getKensakuUpdMstFrom().replace("-", ""));
        }
        //検索条件_更新日(TO)
        if (dto.getKensakuUpdMstTo().isEmpty()) {
        	dto.setKensakuUpdMstTo(null);
        	paramEntity.setKensakuUpdMstTo(null);
        }
        else {
            	dto.setUpdMstTo(dto.getKensakuUpdMstTo());
    			paramEntity.setKensakuUpdMstTo(dto.getKensakuUpdMstTo().replace("-", ""));
        }
        //医師基本情報_検索SQL
        paramEntity.setSqlId("searchUpdHst");

        //画面初期表示時の帳票一覧を取得する
        List<MRdmHcpUpdHstListEntity> SelectHcoUpdHstList = dao.select(paramEntity);

        //検索結果が0件の場合
        if (CollectionUtils.isEmpty(SelectHcoUpdHstList)) {
        	paramEntity.setInLimit(0);
        	return outdto;
        }

        // 件数定義取得
		SelectParamND501Entity selectParamND501Entity = new SelectParamND501Entity();
		List<SelectParamND501Entity> selectParamND501List;
		selectParamND501List = dao.select(selectParamND501Entity);

	    //検索結果が上限以上の場合
	    if (SelectHcoUpdHstList.size() > selectParamND501List.get(0).getValue()) {
	    	dto.setKensakuBool(false);
    		return outdto;
	    }

	    dto.initPageInfo(dto.getPageCntCur(), SelectHcoUpdHstList.size(), selectParamND501List.get(1).getValue());
        paramEntity.setInOffset(dto.getLineCntStart() - 1);
        paramEntity.setInLimit(selectParamND501List.get(1).getValue());
        SelectHcoUpdHstList = dao.select(paramEntity);

	    //検索結果画面受け渡し用リスト
	    List<HcpUpdHstDataList> hcoUpdHstDataList = new ArrayList<HcpUpdHstDataList>();
	    //医師_出身大学マスタ
	    MRdmHcpShusshinkoEntity mRdmHcpShusshinkoEntity = new MRdmHcpShusshinkoEntity();
	    List<MRdmHcpShusshinkoEntity> SelectmRdmHcpShusshinkoList = dao.selectByValue(mRdmHcpShusshinkoEntity);
	    //医師_専門臓器マスタ
	    MRdmHcpSpLiverEntity mRdmHcpSpLiverEntity = new MRdmHcpSpLiverEntity();
	    List<MRdmHcpSpLiverEntity> SelectmRdmHcpSpLiverList = dao.selectByValue(mRdmHcpSpLiverEntity);
	    //医師_専門詳細マスタ
	    MRdmHcpSpDiseaseEntity mRdmHcpSpDiseaseEntity = new MRdmHcpSpDiseaseEntity();
	    List<MRdmHcpSpDiseaseEntity> SelectmRdmHcpSpDiseaseList = dao.selectByValue(mRdmHcpSpDiseaseEntity);

	    //性別区分_生成用エンティティ
    	MRdmCodeMstEntity paramMe = new MRdmCodeMstEntity();
    	//検索条件_性別区分
    	paramMe.setCodeName("MF");
        //性別区分の帳票一覧を取得する
        List<MRdmCodeMstEntity> SelectparamMeList = dao.selectByValue(paramMe);

        //出身地_生成用エンティティ
    	MRdmCodeMstEntity paramHomeTown = new MRdmCodeMstEntity();
    	//検索条件_出身地
    	paramHomeTown.setCodeName("HOME_TOWN");
        //出身地の帳票一覧を取得する
        List<MRdmCodeMstEntity> SelectparamHomeTownList = dao.selectByValue(paramHomeTown);

        //申請チャネル_生成用エンティティ
    	MRdmCodeMstEntity paramReqChl = new MRdmCodeMstEntity();
    	//検索条件_申請チャネル
    	paramReqChl.setCodeName("REQ_CHL");
        //申請チャネルの帳票一覧を取得する
        List<MRdmCodeMstEntity> SelectparamReqChlList = dao.selectByValue(paramReqChl);

        //医師／薬剤師区分_生成用エンティティ
    	MRdmCodeMstEntity paramDocType = new MRdmCodeMstEntity();
    	//検索条件_医師／薬剤師区分
    	paramDocType.setCodeName("DOC_TYPE");
        //医師／薬剤師区分の帳票一覧を取得する
        List<MRdmCodeMstEntity> SelectparamDocTypelList = dao.selectByValue(paramDocType);

        for (MRdmHcpUpdHstListEntity entity : SelectHcoUpdHstList) {
        	HcpUpdHstDataList dataRecord = new HcpUpdHstDataList();

        	if (!StringUtils.isEmpty(entity.getUpdMstYmd())) {//マスタ更新日
        		String yyyy = entity.getUpdMstYmd().substring(0,4);
        		String mm = entity.getUpdMstYmd().substring(4,6);
        		String dd = entity.getUpdMstYmd().substring(6,8);
        		entity.setUpdMstYmd(yyyy + "/" + mm + "/" + dd);
        	}
            dataRecord.setUpdMstYmd(entity.getUpdMstYmd());//マスタ更新日
            dataRecord.setDocNo(entity.getDocNo());//医師固定コード
            //医師／薬剤師区分
            if (!StringUtils.isEmpty(entity.getDocType())) {
            	for (MRdmCodeMstEntity paramDocTypeList : SelectparamDocTypelList) {
            		if (Objects.deepEquals(entity.getDocType(), paramDocTypeList.getValue1())) {
            			entity.setDocType(paramDocTypeList.getValue1Kanj());
            			break;
            		}
            	}
            }
            dataRecord.setDocType(entity.getDocType());


            dataRecord.setDocTypeUpdFlg(entity.getDocTypeUpdFlg());//医師／薬剤師区分更新フラグ
            dataRecord.setDocKanj(entity.getDocKanj());//氏名（漢字)
            dataRecord.setDocKanjUpdFlg(entity.getDocKanjUpdFlg());//氏名（漢字）更新フラグ
            dataRecord.setDocKana(entity.getDocKana());//氏名（カナ）
            dataRecord.setDocKanaUpdFlg(entity.getDocKanaUpdFlg());//氏名（カナ）更新フラグ
            dataRecord.setDocKanjSei(entity.getDocKanjSei());//氏名（漢字）姓
            dataRecord.setDocKanjSeiUpdFlg(entity.getDocKanjSeiUpdFlg());//氏名（漢字）姓更新フラグ
            dataRecord.setDocKanjMei(entity.getDocKanjMei());//氏名（漢字）名
            dataRecord.setDocKanjMeiUpdFlg(entity.getDocKanjMeiUpdFlg());//氏名（漢字）名 更新フラグ
            dataRecord.setDocKanaSei(entity.getDocKanaSei());//氏名（カナ）姓
            dataRecord.setDocKanaSeiUpdFlg(entity.getDocKanaSeiUpdFlg());//氏名（カナ）姓 更新フラグ
            dataRecord.setDocKanaMei(entity.getDocKanaMei());//氏名（カナ）名
            dataRecord.setDocKanaMeiUpdFlg(entity.getDocKanaMeiUpdFlg());//氏名（カナ）名更新フラグ
            dataRecord.setOldKanjSei(entity.getOldKanjSei());//氏名（漢字）旧姓
            dataRecord.setOldKanjSeiUpdFlg(entity.getOldKanjSeiUpdFlg());//氏名（漢字）旧姓更新フラグ
            dataRecord.setOldKanaSei(entity.getOldKanaSei());//氏名（カナ）旧姓
            dataRecord.setOldKanaSeiUpdFlg(entity.getOldKanaSeiUpdFlg());//氏名（カナ）旧姓更新フラグ
            dataRecord.setNewNameStYmd(setFmtYmd(entity.getNewNameStYmd()));//改姓日
            dataRecord.setNewNameStYmdUpdFlg(entity.getNewNameStYmdUpdFlg());//改姓日更新フラグ
            dataRecord.setDobYmd(setFmtYmd(entity.getDobYmd()));//生年月日
            dataRecord.setDobYmdUpdFlg(entity.getDobYmdUpdFlg());//生年月日更新フラグ
            //性別区分
            if (!StringUtils.isEmpty(entity.getSex())) {
            	for (MRdmCodeMstEntity paramMeList : SelectparamMeList) {
            		if (Objects.deepEquals(entity.getSex(), paramMeList.getValue1())) {
            			entity.setSex(paramMeList.getValue1Kanj());
            			break;
            		}
            	}
            }
            dataRecord.setSex(entity.getSex());

            dataRecord.setSexUpdFlg(entity.getSexUpdFlg());//性別区分更新フラグ
            //出身地コード
            if (!StringUtils.isEmpty(entity.getHomeTown())) {
            	for (MRdmCodeMstEntity paramHomeTownList : SelectparamHomeTownList) {
            		if (Objects.deepEquals(entity.getHomeTown(), paramHomeTownList.getValue1())) {
            			entity.setHomeTown(paramHomeTownList.getValue1Kanj());
            			break;
            		}
            	}
            }
            dataRecord.setHomeTown(entity.getHomeTown());

            dataRecord.setHomeTownUpdFlg(entity.getHomeTownUpdFlg());//出身地コード更新フラグ
            //出身校コード
            if (!StringUtils.isEmpty(entity.getMedSch())) {
            	for (MRdmHcpShusshinkoEntity mRdmHcpShusshinko : SelectmRdmHcpShusshinkoList) {
            		if (Objects.deepEquals(entity.getMedSch(), mRdmHcpShusshinko.getUnivCode())) {
            			entity.setMedSch(mRdmHcpShusshinko.getUnivKj());
            			break;
            		}
            	}
            }
            dataRecord.setMedSch(entity.getMedSch());

            dataRecord.setMedSchUpdFlg(entity.getMedSchUpdFlg());//出身校コード更新フラグ
            dataRecord.setGradYear(entity.getGradYear());//卒年
            dataRecord.setGradYearUpdFlg(entity.getGradYearUpdFlg());//卒年更新フラグ
            //出身所属コード
            if (!StringUtils.isEmpty(entity.getSsnDeptCode())) {
            	//医師_所属部科マスタ
            	MRdmHcpUpdHstListEntity shozoku = new MRdmHcpUpdHstListEntity();
            	shozoku.setKensakuDeptCode(entity.getSsnDeptCode());
            	shozoku.setSqlId("selectShozokuBuka");
            	List<MRdmHcpUpdHstListEntity> SelectmShozoku = dao.select(shozoku);
            	if(SelectmShozoku.size() > 0) {
            		entity.setSsnDeptCode(SelectmShozoku.get(0).getDeptKj());
            	} else {
            		entity.setSsnDeptCode("");
            	}
            }
            dataRecord.setSsnDeptCode(entity.getSsnDeptCode());

            dataRecord.setSsnDeptCodeUpdFlg(entity.getSsnDeptCodeUpdFlg());//出身所属コード更新フラグ
            //出身医局校コード
            if (!StringUtils.isEmpty(entity.getHuniv())) {
            	for (MRdmHcpShusshinkoEntity mRdmHcpShusshinko : SelectmRdmHcpShusshinkoList) {
            		if (Objects.deepEquals(entity.getHuniv(), mRdmHcpShusshinko.getUnivCode())) {
            			entity.setHuniv(mRdmHcpShusshinko.getUnivKj());
            			break;
            		}
            	}
            }
            dataRecord.setHuniv(entity.getHuniv());

            dataRecord.setHunivUpdFlg(entity.getHunivUpdFlg());//出身医局校コード更新フラグ
            dataRecord.setEmplYear(entity.getEmplYear());//臨床研修年
            dataRecord.setEmplYearUpdFlg(entity.getEmplYearUpdFlg());//臨床研修年更新フラグ
            //専門臓器コード
            if (!StringUtils.isEmpty(entity.getSpLiver())) {
            	for (MRdmHcpSpLiverEntity mRdmHcpShusshinko : SelectmRdmHcpSpLiverList) {
            		if (Objects.deepEquals(entity.getSpLiver(), mRdmHcpShusshinko.getSpLiver())) {
            			entity.setSpLiver(mRdmHcpShusshinko.getSpLiverKj());
            			break;
            		}
            	}
            }
            dataRecord.setSpLiver(entity.getSpLiver());

            dataRecord.setSpLiverUpdFlg(entity.getSpLiverUpdFlg());//専門臓器コード更新フラグ
            //専門詳細コード
            if (!StringUtils.isEmpty(entity.getSpDisease())) {
            	for (MRdmHcpSpDiseaseEntity mRdmHcpShusshinko : SelectmRdmHcpSpDiseaseList) {
            		if (Objects.deepEquals(entity.getSpDisease(), mRdmHcpShusshinko.getSpDisease())) {
            			entity.setSpDisease(mRdmHcpShusshinko.getSpDiseaseKj());
            			break;
            		}
            	}
            }
            dataRecord.setSpDisease(entity.getSpDisease());


            dataRecord.setSpDiseaseUpdFlg(entity.getSpDiseaseUpdFlg());//専門詳細コード更新フラグ
            dataRecord.setSpCom(entity.getSpCom());//専門追加情報
            dataRecord.setSpComUpdFlg(entity.getSpComUpdFlg());//専門追加情報更新フラグ
            dataRecord.setReqShz(entity.getReqShz());//申請者所属
            dataRecord.setReqJgiName(entity.getReqJgiName());//申請者氏名
            dataRecord.setAprShz(entity.getAprShz());//承認者所属
            dataRecord.setAprShaId(entity.getAprShaId());//承認者氏名
            //申請チャネル
            if (!StringUtils.isEmpty(entity.getReqChl())) {
            	for (MRdmCodeMstEntity paramReqChlList : SelectparamReqChlList) {
            		if (Objects.deepEquals(entity.getReqChl(), paramReqChlList.getValue1())) {
            			entity.setReqChl(paramReqChlList.getValue1Kanj());
            			break;
            		}
            	}
            }
            dataRecord.setReqChl(entity.getReqChl());

            dataRecord.setReqId(entity.getReqId());//申請ID
            dataRecord.setDelFlgUpdFlg(entity.getDelFlgUpdFlg());//削除フラグ更新フラグ

            //リストにデータ追加
            hcoUpdHstDataList.add(dataRecord);
        }

        //検索された帳票一覧をDTOに設定する
        dto.setHcpUpdHstDataList(hcoUpdHstDataList);

        return dto;
    }

    /**
     * イベント処理
     * @param indto ND001DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO page(ND501DTO dto) {
        BaseDTO outdto = dto;
        // START UOC

      //プルダウン・日付データ一覧取得
        outdto = pharmTypeList(dto);

        // END UOC
        return outdto;
    }

    /**
     * イベント処理
     * @param dto ND501DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
   public BaseDTO pharmTypeList(ND501DTO dto) {
    	BaseDTO outdto = dto;

    	//医師／薬剤師区分_生成用エンティティ
    	MRdmCodeMstEntity paramPharmType = new MRdmCodeMstEntity();
    	//検索条件_医師／薬剤師区分
    	paramPharmType.setCodeName("DOC_TYPE");
        //医師／薬剤師区分の帳票一覧を取得する
        List<MRdmCodeMstEntity> SelectDocTypeList = dao.selectByValue(paramPharmType);
        //医師／薬剤師区分データ_取り出す
        LinkedHashMap<String, String> mapDocType = new LinkedHashMap<String, String>();
        mapDocType.put("", "--なし--");
        for (MRdmCodeMstEntity outEntity : SelectDocTypeList) {
        	mapDocType.put(outEntity.getValue1(), outEntity.getValue1() + ":" + outEntity.getValue1Kanj());
        }
        //医師／薬剤師区分を格納する
        dto.setDocTypeMap(mapDocType);

        //検索条件_医師属性
    	paramPharmType.setCodeName("DOC_ATTRIBUTE");
        //医師属性の帳票一覧を取得する
        List<MRdmCodeMstEntity> SelectDocAttributeList = dao.selectByValue(paramPharmType);
        //医師属性データ_取り出す
        LinkedHashMap<String, String> docAttributeMap = new LinkedHashMap<String, String>();
        docAttributeMap.put("", "--なし--");
        for (MRdmCodeMstEntity outEntity : SelectDocAttributeList) {
        	docAttributeMap.put(outEntity.getValue1(), outEntity.getValue1() + ":" + outEntity.getValue1Kanj());
        }
        //医師属性を格納する
        dto.setDocAttributeMap(docAttributeMap);

      //検索結果切り替えリスト_作成
        LinkedHashMap<String, String> selectListChangeMap = new LinkedHashMap<String, String>();
        selectListChangeMap.put("0", "医師基本情報");
        selectListChangeMap.put("1", "勤務先情報");
        selectListChangeMap.put("2", "所属学会");
        selectListChangeMap.put("3", "公的機関");
        //検索結果切り替えリストを格納する
        dto.setSelectListChangeMap(selectListChangeMap);

        //出身校_一覧
        MRdmHcpShusshinkoEntity paramMedSch = new MRdmHcpShusshinkoEntity();
        //検索条件_出身校フラグ
        paramMedSch.setUnivFlg(1);
        //検索条件_削除フラグ
        paramMedSch.setDelFlg(0);
        //出身校の帳票一覧を取得する
        List<MRdmHcpShusshinkoEntity> SelectMedSchList = dao.selectByValue(paramMedSch);
        //出身校データ_取り出す
        LinkedHashMap<String, String> mapMedSch = new LinkedHashMap<String, String>();
        mapMedSch.put("", "--なし--");
        for (MRdmHcpShusshinkoEntity outEntity : SelectMedSchList) {
        	mapMedSch.put(outEntity.getUnivCode(), outEntity.getUnivKj());
        }
        //出身校を格納する
        dto.setMedSchMap(mapMedSch);

        //出身医局校_一覧
        MRdmHcpShusshinkoEntity paramHUniv = new MRdmHcpShusshinkoEntity();
        //検索条件_出身医局校フラグ
        paramHUniv.setUnivIkkFlg(1);
        //検索条件_削除フラグ
        paramHUniv.setDelFlg(0);
        //出身医局校の帳票一覧を取得する
        List<MRdmHcpShusshinkoEntity> SelectHUnivList = dao.selectByValue(paramHUniv);
        //出身医局校データ_取り出す
        LinkedHashMap<String, String> mapHUniv = new LinkedHashMap<String, String>();
        mapHUniv.put("", "--なし--");
        for (MRdmHcpShusshinkoEntity outEntity : SelectHUnivList) {
        	mapHUniv.put(outEntity.getUnivCode(), outEntity.getUnivKj());
        }
        //出身医局校を格納する
        dto.setHunivMap(mapHUniv);

        //卒年
        MRdmComCalUsrEntity inEntityYearCmb = new MRdmComCalUsrEntity();
		inEntityYearCmb.setToday("1");
		MRdmComCalUsrEntity outCalUsr = dao.selectByValue(inEntityYearCmb).get(0);
        LinkedHashMap<String, String> mapGradYear = new LinkedHashMap<String, String>();
        mapGradYear.put(null, "");
        Integer thisYear = Integer.parseInt(outCalUsr.getCalYear());
        Integer futureYear = thisYear + 1;
        String futureYearString = Integer.toString(futureYear);
        mapGradYear.put(futureYearString,futureYearString);
        mapGradYear.put(outCalUsr.getCalYear(),outCalUsr.getCalYear());
        for (int i = 1; i < 101; i++){
            Integer year = Integer.parseInt(outCalUsr.getCalYear()) - i;
            String yearString = Integer.toString(year);
            mapGradYear.put(yearString, yearString);
        }
        //卒年を格納する
        dto.setGradYearMap(mapGradYear);

       	//本日日付_RDM用カレンダー(オンライン用)_生成用エンティテ

        //本日日付_RDM用カレンダー(オンライン用)の帳票一覧を取得する
    	MRdmComCalUsrEntity today = dao.selectByValue(inEntityYearCmb).get(0);

        // SimpleDateFormatで日付フォーマット設定
     	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
     	String todayYMD = today.getCalYear() + "-" + today.getCalMonth() + "-" + today.getCalDay();

     	//検索結果_本日日付
        dto.setUpdMstTo(todayYMD);
        dto.setClearUpdMstTo(todayYMD);

        String YMD = today.getCalYear() + today.getCalMonth() + today.getCalDay();

        Date date = null;
        try {
			date = sdf.parse(YMD);
		} catch (ParseException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.add(Calendar.MONTH, -3);
        date = calendar.getTime();
        String strDate = sdf.format(date);

        dto.setUpdMstFrom(strDate.substring(0,4) + "-" + strDate.substring(4,6) + "-" + strDate.substring(6,8));
        dto.setClearUpdMstFrom(strDate.substring(0,4) + "-" + strDate.substring(4,6) + "-" + strDate.substring(6,8));

    	// END UOC
        return dto;
    }

    /**
     * yyyy + / + mm + / + dd で作成された文字列に対して、下記変換を行う
     * 年、月、日　がないものは空白("//"→"")
     * 日がないものは、年/月("yyyy/mm/"→"yyyy/mm")
     * 月、日がないものは、年のみ("yyyy//"→"yyyy")
     * @param ymd
     * @return
     */
    public String setFmtYmd(String ymd) {
    	String rtnYmd = ymd;
    	if(rtnYmd == null) {
    		rtnYmd = "";
    	}

    	if("//".equals(rtnYmd)) {
    		rtnYmd = "";
    	} else {
	    	while(rtnYmd.length() > 0 && "/".equals(rtnYmd.substring(rtnYmd.length()-1))) {
	    		rtnYmd = rtnYmd.substring(0, rtnYmd.length()-1);
	    	}
    	}

    	return rtnYmd;
    }
}
