/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.inject.Named;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

import jp.co.takeda.rdm.common.BaseDTO;
import jp.co.takeda.rdm.common.BaseInfoHolder;
import jp.co.takeda.rdm.common.BaseService;
import jp.co.takeda.rdm.common.LoginInfo;
import jp.co.takeda.rdm.dto.HcoSearchDataList;
import jp.co.takeda.rdm.dto.NF001DTO;
import jp.co.takeda.rdm.entity.MRdmHcoKeieitaiEntiry;
import jp.co.takeda.rdm.entity.SRdmJkrSosAddrEntiry;
import jp.co.takeda.rdm.entity.join.MRdmParamMstEntity;
import jp.co.takeda.rdm.entity.join.SRdmJkrSosAddrEntity;
import jp.co.takeda.rdm.entity.join.SelectComboListEntity;
import jp.co.takeda.rdm.entity.join.SelectHenkanListEntity;
import jp.co.takeda.rdm.entity.join.SelectNF001MainDataEntity;
import jp.co.takeda.rdm.entity.join.SelectParamNF001Entity;
import jp.co.takeda.rdm.util.RdmConstantsData;
import jp.co.takeda.rdm.util.StringUtils;

/**
 * Serviceクラス（NF001)
 * @generated
 */
@Named
public class NF001Service extends BaseService {

    /**
     * ログインスタンス
     * @generated
     */
    private static Log log = LogFactory.getLog(NF001Service.class);

    /**
     * イベント処理
     * @param indto RDMNF001DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO init(NF001DTO indto) {
        BaseDTO outdto = indto;
        // START UOC
        LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();

        // DropDownList作成
        createCombo(indto);

        // ページ数(現在:１ページ目から)
        indto.setPageCntCur(1);

        indto.setPageFlag("1");

        // MR権限の場合、親画面．ログインユーザ情報からログインユーザの従業員番号、氏名、組織コード、医薬支店C、医薬営業所C、所属組織名を取得し
        // 検索条件．組織、検索条件．担当者に設定する
        if(RdmConstantsData.RDM_JKN_MR.equals(indto.getLoginJokenSetCd())) {
        	indto.setUpSosCd(loginInfo.getUpSosCd());
        	indto.setSosCd(loginInfo.getSosCd());
        	indto.setSosNm(indto.getLoginShzNm());
        	indto.setJgiNo(Integer.toString(loginInfo.getJgiNo()));
        	indto.setJgiNm(loginInfo.getJgiName());
        	indto.setBrCode(loginInfo.getBrCode());
        	indto.setDistCode(loginInfo.getDistCode());
        	indto.setBumonRank(loginInfo.getBumonRank());
        }

        // END UOC
        return outdto;

    }

	public BaseDTO search(NF001DTO indto) {
		BaseDTO outdto = indto;
		LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();
		// DropDownList作成
        createCombo(indto);

        // エラーチェック
        // 検索項目未入力の場合
        boolean inputFlg = false;

        if(indto.getSosCd() != null && !indto.getSosCd().isEmpty()) {
        	inputFlg = true;
        } else if(indto.getJgiNo() != null && !indto.getJgiNo().isEmpty()) {
        	inputFlg = true;
        } else if(indto.getDelKbn() != null && !indto.getDelKbn().isEmpty()) {
        	inputFlg = true;
        } else if(indto.getInsKanjSrch() != null && !indto.getInsKanjSrch().isEmpty()) {
        	inputFlg = true;
        } else if(indto.getInsKanaSrch() != null && !indto.getInsKanaSrch().isEmpty()) {
        	inputFlg = true;
        } else if(indto.getDelFlg() != null && !indto.getDelFlg().isEmpty()) {
        	inputFlg = true;
        } else if(indto.getInsNo() != null && !indto.getInsNo().isEmpty()) {
        	inputFlg = true;
        } else if(indto.getUltInsNo() != null && !indto.getUltInsNo().isEmpty()) {
        	inputFlg = true;
        } else if(indto.getKeieitai() != null && !indto.getKeieitai().isEmpty()) {
        	inputFlg = true;
        } else if(indto.getHoInsType() != null && !indto.getHoInsType().isEmpty()) {
        	inputFlg = true;
        } else if(indto.getInsType() != null && !indto.getInsType().isEmpty()) {
        	inputFlg = true;
        } else if(indto.getPharmType() != null && !indto.getPharmType().isEmpty()) {
        	inputFlg = true;
        } else if(indto.getInsPhoneSrch() != null && !indto.getInsPhoneSrch().isEmpty()) {
        	inputFlg = true;
        } else if(indto.getInsPcode() != null && !indto.getInsPcode().isEmpty()) {
        	inputFlg = true;
        } else if(indto.getAddrCodePref() != null && !indto.getAddrCodePref().isEmpty()) {
        	inputFlg = true;
        } else if(indto.getAddrCodeCity() != null && !indto.getAddrCodeCity().isEmpty()) {
        	inputFlg = true;
        } else if(indto.getInsAddrSrch() != null && !indto.getInsAddrSrch().isEmpty()) {
        	inputFlg = true;
        }

        if (!inputFlg) {
      	  // 検索条件を入力してください。
      	  String tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W001);
      	  //エラーメッセージをdtoに格納
      	  indto.setMsgStr(tmpMsgStr);
      	  return outdto;
      }

        // 一覧表示データ
        List<HcoSearchDataList> hcoSearchDataList = new ArrayList<HcoSearchDataList>();

        // 件数定義取得
  		SelectParamNF001Entity selectParamReqNF001Entity = new SelectParamNF001Entity();
  		List<SelectParamNF001Entity> selectParamNF001List = dao.select(selectParamReqNF001Entity);

  		// 表示データ取得
  		SelectNF001MainDataEntity selectNF001MainDataCntEntity = new SelectNF001MainDataEntity("selectNF001DataListCnt");
  		SelectNF001MainDataEntity selectNF001MainDataEntity = new SelectNF001MainDataEntity("selectNF001DataList");

  		// 廃院区分
  		selectNF001MainDataCntEntity.setDelKbn(StringUtils.setEmptyToNull(indto.getDelKbn()));
  		selectNF001MainDataEntity.setDelKbn(StringUtils.setEmptyToNull(indto.getDelKbn()));

  		// 施設名(全角)
  		// 漢字変換(F_RDM_KJ_HENKAN)
        if(indto.getInsKanjSrch() != null && !indto.getInsKanjSrch().isEmpty()) {
        	SelectHenkanListEntity henkanEntity = new SelectHenkanListEntity("漢字変換");
        	henkanEntity.setSearchHenkan(indto.getInsKanjSrch());
        	// 漢字変換
        	List<SelectHenkanListEntity> selectHenkanListEntity = dao.select(henkanEntity);
        	// 漢字変換後の値をセット
        	String zenkaku = selectHenkanListEntity.get(0).getSearchHenkan();
    		selectNF001MainDataCntEntity.setInsKanjSrch(zenkaku);
    		selectNF001MainDataEntity.setInsKanjSrch(zenkaku);
        }

        // 施設名カナ(半角カナ)
  		// 半角変換(F_RDM_HW_HENKAN)、ハイフン変換(F_RDM_HY_HENKAN)
        if(indto.getInsKanaSrch() != null && !indto.getInsKanaSrch().isEmpty()) {
        	SelectHenkanListEntity henkanEntity = new SelectHenkanListEntity("半角変換");
        	henkanEntity.setSearchHenkan(indto.getInsKanaSrch());
        	// 半角変換
        	List<SelectHenkanListEntity> selectHenkanListEntity = dao.select(henkanEntity);
        	// 変換変換後の値をセット
        	String hankaku = selectHenkanListEntity.get(0).getSearchHenkan();

        	// ハイフン変換
        	SelectHenkanListEntity hyphenHenkanEntity = new SelectHenkanListEntity("ハイフン変換");
        	hyphenHenkanEntity.setSearchHenkan(hankaku);
        	// ハイフン変換
        	List<SelectHenkanListEntity> selectHyphenHenkanListEntity = dao.select(hyphenHenkanEntity);
        	// ハイフン変換後の値をセット
        	String hyphen = selectHyphenHenkanListEntity.get(0).getSearchHenkan();
    		selectNF001MainDataCntEntity.setInsKanaSrch(hyphen);
    		selectNF001MainDataEntity.setInsKanaSrch(hyphen);
        }

        // 削除フラグ
  		selectNF001MainDataCntEntity.setDelFlg(StringUtils.setEmptyToNull(indto.getDelFlg()));
  		selectNF001MainDataEntity.setDelFlg(StringUtils.setEmptyToNull(indto.getDelFlg()));

  		// 施設固定コード
  		selectNF001MainDataCntEntity.setInsNo(StringUtils.setEmptyToNull(indto.getInsNo()));
  		selectNF001MainDataEntity.setInsNo(StringUtils.setEmptyToNull(indto.getInsNo()));

  		// 経営主体コード
  		selectNF001MainDataCntEntity.setKeieitai(StringUtils.setEmptyToNull(indto.getKeieitai()));
  		selectNF001MainDataEntity.setKeieitai(StringUtils.setEmptyToNull(indto.getKeieitai()));

  		// 対象区分
  		selectNF001MainDataCntEntity.setHoInsType(StringUtils.setEmptyToNull(indto.getHoInsType()));
  		selectNF001MainDataEntity.setHoInsType(StringUtils.setEmptyToNull(indto.getHoInsType()));

  		// 施設種別
  		selectNF001MainDataCntEntity.setInsType(StringUtils.setEmptyToNull(indto.getInsType()));
  		selectNF001MainDataEntity.setInsType(StringUtils.setEmptyToNull(indto.getInsType()));

  		// 施設区分
  		selectNF001MainDataCntEntity.setPharmType(StringUtils.setEmptyToNull(indto.getPharmType()));
  		selectNF001MainDataEntity.setPharmType(StringUtils.setEmptyToNull(indto.getPharmType()));

  		// 電話番号(半角)
  		// ハイフン除去(F_RDM_HY_REMOVE)
        if(indto.getInsPhoneSrch() != null && !indto.getInsPhoneSrch().isEmpty()) {
        	SelectHenkanListEntity henkanEntity = new SelectHenkanListEntity("ハイフン除去");
        	henkanEntity.setSearchHenkan(indto.getInsPhoneSrch());
        	// ハイフン除去
        	List<SelectHenkanListEntity> selectHenkanListEntity = dao.select(henkanEntity);
        	// ハイフン除去後の値をセット
        	String phone = selectHenkanListEntity.get(0).getSearchHenkan();
    		selectNF001MainDataCntEntity.setInsPhoneSrch(phone);
    		selectNF001MainDataEntity.setInsPhoneSrch(phone);
        }

        // 郵便番号(半角)
  		// ハイフン除去(F_RDM_HY_REMOVE)
        if(indto.getInsPcode() != null && !indto.getInsPcode().isEmpty()) {
        	SelectHenkanListEntity henkanEntity = new SelectHenkanListEntity("ハイフン除去");
        	henkanEntity.setSearchHenkan(indto.getInsPcode());
        	// ハイフン除去
        	List<SelectHenkanListEntity> selectHenkanListEntity = dao.select(henkanEntity);
        	// ハイフン除去後の値をセット
        	String pcode = selectHenkanListEntity.get(0).getSearchHenkan();
    		selectNF001MainDataCntEntity.setInsPcode(pcode);
    		selectNF001MainDataEntity.setInsPcode(pcode);
        }

        // 都道府県
  		selectNF001MainDataCntEntity.setAddrCodePref(StringUtils.setEmptyToNull(indto.getAddrCodePref()));
  		selectNF001MainDataEntity.setAddrCodePref(StringUtils.setEmptyToNull(indto.getAddrCodePref()));

        // JIS市区町村
  		if(indto.getAddrCodeCity() != null && !"".equals(indto.getAddrCodeCity())){
  			selectNF001MainDataCntEntity.setAddrCodeCity(StringUtils.setEmptyToNull(indto.getAddrCodeCity().substring(2)));
  			selectNF001MainDataEntity.setAddrCodeCity(StringUtils.setEmptyToNull(indto.getAddrCodeCity().substring(2)));
  		}

  		// 住所(全角)
  		// 全角変換(F_RDM_FW_HENKAN)
        if(indto.getInsAddrSrch() != null && !indto.getInsAddrSrch().isEmpty()) {
        	SelectHenkanListEntity henkanEntity = new SelectHenkanListEntity("全角変換");
        	henkanEntity.setSearchHenkan(indto.getInsAddrSrch());
        	// 全角変換
        	List<SelectHenkanListEntity> selectHenkanListEntity = dao.select(henkanEntity);
        	// 全角変換後の値をセット
        	String addr = selectHenkanListEntity.get(0).getSearchHenkan();
    		selectNF001MainDataCntEntity.setInsAddrSrch(addr);
    		selectNF001MainDataEntity.setInsAddrSrch(addr);
        }

        // ULT施設コード
  		selectNF001MainDataCntEntity.setUltInsNo(StringUtils.setEmptyToNull(indto.getUltInsNo()));
  		selectNF001MainDataEntity.setUltInsNo(StringUtils.setEmptyToNull(indto.getUltInsNo()));

  		// 部門ランク
  		selectNF001MainDataCntEntity.setBumonRank(StringUtils.setEmptyToNull(indto.getBumonRank()));
  		selectNF001MainDataEntity.setBumonRank(StringUtils.setEmptyToNull(indto.getBumonRank()));

  		// 組織
  		selectNF001MainDataCntEntity.setSosCd(StringUtils.setEmptyToNull(indto.getSosCd()));
  		selectNF001MainDataEntity.setSosCd(StringUtils.setEmptyToNull(indto.getSosCd()));

  		// 医薬支店C
  		selectNF001MainDataCntEntity.setBrCode(StringUtils.setEmptyToNull(indto.getBrCode()));
  		selectNF001MainDataEntity.setBrCode(StringUtils.setEmptyToNull(indto.getBrCode()));

  		// 医薬営業所C
  		selectNF001MainDataCntEntity.setDistCode(StringUtils.setEmptyToNull(indto.getDistCode()));
  		selectNF001MainDataEntity.setDistCode(StringUtils.setEmptyToNull(indto.getDistCode()));

  		// 担当者
  		selectNF001MainDataCntEntity.setJgiNo(StringUtils.setEmptyToNull(indto.getJgiNo()));
  		selectNF001MainDataEntity.setJgiNo(StringUtils.setEmptyToNull(indto.getJgiNo()));

  		// ログイン組織
  		selectNF001MainDataCntEntity.setLoginSosCd(StringUtils.setEmptyToNull(loginInfo.getSosCd()));
  		selectNF001MainDataEntity.setLoginSosCd(StringUtils.setEmptyToNull(loginInfo.getSosCd()));

  		// ログイン担当者
  		selectNF001MainDataCntEntity.setLoginJgiNo(StringUtils.setEmptyToNull(Integer.toString(loginInfo.getJgiNo())));
  		selectNF001MainDataEntity.setLoginJgiNo(StringUtils.setEmptyToNull(Integer.toString(loginInfo.getJgiNo())));

        //ソートIDのセット
  		if(indto.getSortCondition() == null || indto.getSortCondition().isEmpty()) {
  			selectNF001MainDataEntity.setInSortId("0");
  			indto.setSortCondition("0");
  		} else {
  			selectNF001MainDataEntity.setInSortId(indto.getSortCondition());
  		}

        // 件数取得
        List<SelectNF001MainDataEntity> selectNF001MainDataCntList  = dao.select(selectNF001MainDataCntEntity);

        //1000件以上の場合のエラー
        if (selectNF001MainDataCntList.get(0).getCnt() > selectParamNF001List.get(0).getValue()) {
        	  // 検索結果が表示上限を超えています。検索条件を絞って再検索してください。。
        	  String tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W002);
        	  //エラーメッセージをdtoに格納
        	  indto.setMsgStr(tmpMsgStr);
        	  return outdto;
        }

        indto.initPageInfo(indto.getPageCntCur(), selectNF001MainDataCntList.get(0).getCnt(), selectParamNF001List.get(1).getValue());
        selectNF001MainDataEntity.setInOffset(indto.getLineCntStart() - 1);
        selectNF001MainDataEntity.setInLimit(selectParamNF001List.get(1).getValue());
        indto.setPageFlag("0");

        // 機能定義取得
        String newValue = "0";
        String editValue = "0";
        String delValue = "0";
        String revValue = "0";

        MRdmParamMstEntity mRdmParamMstEntity = new MRdmParamMstEntity();
		mRdmParamMstEntity.setParamName("MN_FAC");
		mRdmParamMstEntity.setDelFlg("0");

		List<MRdmParamMstEntity> mRdmParamMstEntityList = dao.selectByValue(mRdmParamMstEntity);
		if(mRdmParamMstEntityList.size() > 0) {
			// 新規・編集・削除・復活　各桁0の場合対応するアクションボタン非表示にする
			newValue = mRdmParamMstEntityList.get(0).getValue().substring(0,1);
			editValue = mRdmParamMstEntityList.get(0).getValue().substring(1,2);
			delValue = mRdmParamMstEntityList.get(0).getValue().substring(2,3);
			revValue = mRdmParamMstEntityList.get(0).getValue().substring(3);
		}

        // 一覧を取得する
        List<SelectNF001MainDataEntity> selectNF001MainDataEntityList = dao.select(selectNF001MainDataEntity);

        for (SelectNF001MainDataEntity entity : selectNF001MainDataEntityList) {
        	HcoSearchDataList dataRecord = new HcoSearchDataList();

      		// 施設略式漢字名
        	if(entity.getInsAbbrName() != null && !entity.getInsAbbrName().isEmpty()) {
        		dataRecord.setInsAbbrName(entity.getInsAbbrName());
        	} else {
        		dataRecord.setInsAbbrName(" ");
        	}

        	// 施設正式漢字名
        	if(entity.getInsFormalName() != null && !entity.getInsFormalName().isEmpty()) {
        		dataRecord.setInsFormalName(entity.getInsFormalName());
        	} else {
        		dataRecord.setInsFormalName(" ");
        	}

        	// 施設固定コード
        	if(entity.getInsNo() != null && !entity.getInsNo().isEmpty()) {
        		dataRecord.setInsNo(entity.getInsNo());
        	} else {
        		dataRecord.setInsNo(" ");
        	}

        	// 施設住所
        	if(entity.getInsAddr() != null && !entity.getInsAddr().isEmpty()) {
        		dataRecord.setInsAddr(entity.getInsAddr());
        	} else {
        		dataRecord.setInsAddr(" ");
        	}

        	// 電話番号
        	if(entity.getInsPhone1() != null && !entity.getInsPhone1().isEmpty()) {
        		dataRecord.setInsPhone1(entity.getInsPhone1());
        	} else {
        		dataRecord.setInsPhone1(" ");
        	}

        	// 施設種別
        	if(entity.getInsType() != null && !entity.getInsType().isEmpty()) {
        		dataRecord.setInsType(entity.getInsType());
        	} else {
        		dataRecord.setInsType(" ");
        	}

        	// 経営主体
        	if(entity.getKeieitaiKj() != null && !entity.getKeieitaiKj().isEmpty()) {
        		dataRecord.setKeieitaiKj(entity.getKeieitaiKj());
        	} else {
        		dataRecord.setKeieitaiKj(" ");
        	}

        	// ベッド数計
        	if(entity.getBedsTot() != null && !entity.getBedsTot().isEmpty()) {
        		dataRecord.setBedsTot(entity.getBedsTot());
        	} else {
        		dataRecord.setBedsTot(" ");
        	}

        	// 医師数
        	if(entity.getDocCount() != null && !entity.getDocCount().isEmpty()) {
        		dataRecord.setDocCount(entity.getDocCount());
        	} else {
        		dataRecord.setDocCount(" ");
        	}

        	// 当期納入計画
        	if(entity.getPlnValue() != null && !"0".equals(entity.getPlnValue())) {
        		dataRecord.setPlnValue("あり");
        	} else {
        		dataRecord.setPlnValue("なし");
        	}

        	// 当期納入実績
        	if(entity.getJskValueTk() != null && !"0".equals(entity.getJskValueTk())) {
        		dataRecord.setJskValueTk("あり");
        	} else {
        		dataRecord.setJskValueTk("なし");
        	}

        	// 前期納入実績
        	if(entity.getJskValueZk() != null && !"0".equals(entity.getJskValueZk())) {
        		dataRecord.setJskValueZk("あり");
        	} else {
        		dataRecord.setJskValueZk("なし");
        	}

        	// 前々期納入実績
        	if(entity.getJskValueZzk() != null && !"0".equals(entity.getJskValueZzk())) {
        		dataRecord.setJskValueZzk("あり");
        	} else {
        		dataRecord.setJskValueZzk("なし");
        	}

        	// 廃院区分
        	if(entity.getDelKbn() != null && !entity.getDelKbn().isEmpty()) {
        		dataRecord.setDelKbn(entity.getDelKbn());
        	} else {
        		dataRecord.setDelKbn(" ");
        	}

        	// 削除フラグ
        	if(entity.getDelFlgNm() != null && !entity.getDelFlgNm().isEmpty()) {
        		dataRecord.setDelFlg(entity.getDelFlgNm());
        	} else {
        		dataRecord.setDelFlg(" ");
        	}

        	// 施設責任者組織
        	if(entity.getBumonRyakuName() != null && !entity.getBumonRyakuName().isEmpty()) {
        		dataRecord.setBumonRyakuName(entity.getBumonRyakuName());
        	} else {
        		dataRecord.setBumonRyakuName(" ");
        	}

        	// 施設責任者
        	if(entity.getJgiName() != null && !entity.getJgiName().isEmpty()) {
        		dataRecord.setJgiName(entity.getJgiName());
        	} else {
        		dataRecord.setJgiName(" ");
        	}

        	// ULT施設略名
        	if(entity.getShisetsuNmRyaku() != null && !entity.getShisetsuNmRyaku().isEmpty()) {
        		dataRecord.setShisetsuNmRyaku(entity.getShisetsuNmRyaku());
        	} else {
        		dataRecord.setShisetsuNmRyaku(" ");
        	}

        	// ULT施設名正式名
        	if(entity.getShisetsuNm() != null && !entity.getShisetsuNm().isEmpty()) {
        		dataRecord.setShisetsuNm(entity.getShisetsuNm());
        	} else {
        		dataRecord.setShisetsuNm(" ");
        	}

        	// ULT施設コード
        	if(entity.getDcfShisetsuCd() != null && !entity.getDcfShisetsuCd().isEmpty()) {
        		dataRecord.setDcfShisetsuCd(entity.getDcfShisetsuCd());
        	} else {
        		dataRecord.setDcfShisetsuCd(" ");
        	}

        	// ULT住所
        	if(entity.getAddress() != null && !entity.getAddress().isEmpty()) {
        		dataRecord.setAddress(entity.getAddress());
        	} else {
        		dataRecord.setAddress(" ");
        	}

        	// ULT電話番号
        	if(entity.getShisetsuTel() != null && !entity.getShisetsuTel().isEmpty()) {
        		dataRecord.setShisetsuTel(entity.getShisetsuTel());
        	} else {
        		dataRecord.setShisetsuTel(" ");
        	}

        	// ULT施設区分
        	if(entity.getUltPharmType() != null && !entity.getUltPharmType().isEmpty()) {
        		dataRecord.setUltPharmType(entity.getUltPharmType());
        	} else {
        		dataRecord.setUltPharmType(" ");
        	}

        	// ULT経営主体
        	if(entity.getUltKeieitaiKj() != null && !entity.getUltKeieitaiKj().isEmpty()) {
        		dataRecord.setUltKeieitaiKj(entity.getUltKeieitaiKj());
        	} else {
        		dataRecord.setUltKeieitaiKj(" ");
        	}

        	// ULTベッド数計
        	if(entity.getByoshoSu() != null && !entity.getByoshoSu().isEmpty()) {
        		dataRecord.setByoshoSu(entity.getByoshoSu());
        	} else {
        		dataRecord.setByoshoSu(" ");
        	}

        	// 機能フラグ1 新規作成
        	String funcFlg1 = "0";
        	if(entity.getInsNo() == null && entity.getDcfShisetsuCd() != null) {
        		funcFlg1 = "1";
        	}

        	// 機能フラグ2 編集
        	String funcFlg2 = "0";
        	if(entity.getInsNo() != null && "0".equals(entity.getDelFlg())) {
        		funcFlg2 = "1";
        	}

        	// 機能フラグ3 削除
        	String funcFlg3 = "0";
        	if(entity.getInsNo() != null && "0".equals(entity.getDelFlg())) {
        		funcFlg3 = "1";
        	}

        	// 機能フラグ4 復活
        	String funcFlg4 = "0";
        	if(entity.getInsNo() != null && ("1".equals(entity.getDelKbn()) || "2".equals(entity.getDelKbn())
        			|| "3".equals(entity.getDelKbn()))) {
        		funcFlg4 = "1";
        	}

        	// 機能フラグ5 親子紐づけ
        	String funcFlg5 = "0";
        	if(entity.getInsNo() != null && "0".equals(entity.getDelFlg())
        			&& !"06".equals(entity.getInsClass()) && "1".equals(entity.getValueCt())) {
        		funcFlg5 = "1";
        	}

        	// 機能フラグ6 来期用項目更新
        	String funcFlg6 = "0";
        	if(entity.getInsNo() != null && "0".equals(entity.getDelFlg())
        			&& "1".equals(entity.getValueFac())) {
        		funcFlg6 = "1";
        	}

        	// 機能フラグ7 親子紐付け（来期）
        	String funcFlg7 = "0";
        	if(entity.getInsNo() != null && "0".equals(entity.getDelFlg())
        			&& !"06".equals(entity.getInsClass()) && "1".equals(entity.getValueNt())) {
        		funcFlg7 = "1";
        	}

        	// MR新規判定フラグ
        	String mrNewFlg = "0";
        	if(entity.getSosCd() != null) {
        		mrNewFlg = "1";
        	}

        	// MR更新判定フラグ
//        	String mrUpdFlg = "0";
//        	if(entity.getJgiNo() != null) {
//        		mrUpdFlg = "1";
//        	}

        	// 新規作成
        	if("1".equals(funcFlg1) && "1".equals(newValue)) {
        		if(RdmConstantsData.RDM_JKN_ADMIN.equals(indto.getLoginJokenSetCd())) {
        			dataRecord.setFuncFlg1("1");
        		} else if(RdmConstantsData.RDM_JKN_MR.equals(indto.getLoginJokenSetCd()) && "1".equals(mrNewFlg)) {
        			dataRecord.setFuncFlg1("1");
        		} else {
        			dataRecord.setFuncFlg1("0");
        		}
        	} else {
        		dataRecord.setFuncFlg1("0");
        	}

        	// 編集
        	if("1".equals(funcFlg2) && "1".equals(editValue)) {
        		if(RdmConstantsData.RDM_JKN_ADMIN.equals(indto.getLoginJokenSetCd())) {
        			dataRecord.setFuncFlg2("1");
        		} else if(RdmConstantsData.RDM_JKN_MR.equals(indto.getLoginJokenSetCd()) && "1".equals(mrNewFlg)) {
        			dataRecord.setFuncFlg2("1");
        		} else {
        			dataRecord.setFuncFlg2("0");
        		}
        	} else {
        		dataRecord.setFuncFlg2("0");
        	}

        	// 削除
        	if("1".equals(funcFlg3) && "1".equals(delValue)) {
        		if(RdmConstantsData.RDM_JKN_ADMIN.equals(indto.getLoginJokenSetCd())) {
        			dataRecord.setFuncFlg3("1");
        		} else if(RdmConstantsData.RDM_JKN_MR.equals(indto.getLoginJokenSetCd()) && "1".equals(mrNewFlg)) {
        			dataRecord.setFuncFlg3("1");
        		} else {
        			dataRecord.setFuncFlg3("0");
        		}
        	} else {
        		dataRecord.setFuncFlg3("0");
        	}

        	// 復活
        	if("1".equals(funcFlg4) && "1".equals(revValue)) {
        		if(RdmConstantsData.RDM_JKN_ADMIN.equals(indto.getLoginJokenSetCd())) {
        			dataRecord.setFuncFlg4("1");
        		} else if(RdmConstantsData.RDM_JKN_MR.equals(indto.getLoginJokenSetCd()) && "1".equals(mrNewFlg)) {
        			dataRecord.setFuncFlg4("1");
        		} else {
        			dataRecord.setFuncFlg4("0");
        		}
        	} else {
        		dataRecord.setFuncFlg4("0");
        	}

        	// 親子紐づけ
        	if("1".equals(funcFlg5) && "1".equals(editValue)) {
        		if(RdmConstantsData.RDM_JKN_ADMIN.equals(indto.getLoginJokenSetCd())) {
        			dataRecord.setFuncFlg5("1");
        		} else if(RdmConstantsData.RDM_JKN_MR.equals(indto.getLoginJokenSetCd()) && "1".equals(mrNewFlg)) {
        			dataRecord.setFuncFlg5("1");
        		} else {
        			dataRecord.setFuncFlg5("0");
        		}
        	} else {
        		dataRecord.setFuncFlg5("0");
        	}

        	// 来期用項目更新
        	if("1".equals(funcFlg6) && "1".equals(editValue)) {
        		if(RdmConstantsData.RDM_JKN_ADMIN.equals(indto.getLoginJokenSetCd())) {
        			dataRecord.setFuncFlg6("1");
        		} else if(RdmConstantsData.RDM_JKN_MR.equals(indto.getLoginJokenSetCd()) && "1".equals(mrNewFlg)) {
        			dataRecord.setFuncFlg6("1");
        		} else {
        			dataRecord.setFuncFlg6("0");
        		}
        	} else {
        		dataRecord.setFuncFlg6("0");
        	}

        	// 親子紐づけ(来期)
        	if("1".equals(funcFlg7) && "1".equals(editValue)) {
        		if(RdmConstantsData.RDM_JKN_ADMIN.equals(indto.getLoginJokenSetCd())) {
        			dataRecord.setFuncFlg7("1");
        		} else if(RdmConstantsData.RDM_JKN_MR.equals(indto.getLoginJokenSetCd()) && "1".equals(mrNewFlg)) {
        			dataRecord.setFuncFlg7("1");
        		} else {
        			dataRecord.setFuncFlg7("0");
        		}
        	} else {
        		dataRecord.setFuncFlg7("0");
        	}

        	hcoSearchDataList.add(dataRecord);
        }

        indto.setHcoSearchDataList(hcoSearchDataList);

        indto.setSrchFlg("1");

        // END UOC
       	return outdto;
	}

    /**
     * イベント処理
     * @param indto ND001DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO page(NF001DTO indto) {
        BaseDTO outdto = indto;
        // START UOC

        outdto = search(indto);

        // END UOC
        return outdto;
    }

    /**
     * コンボ作成
     * @param indto NF001DTO
     * @return なし
     * @customizable
     */
    private void createCombo(NF001DTO indto){
		//1-2-1			廃院区分
		//コード情報から下記条件で値１：値１（漢字）を値１順に取得しドロップダウンリストを作成する
		//コード名＝DEL_KBN（削除区分）
		//削除フラグ=0
    	SelectComboListEntity inEntityCmb = new SelectComboListEntity();
    	inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_DEL_KBN);
        List<SelectComboListEntity> outMainList = dao.select(inEntityCmb);
        LinkedHashMap<String, String> mapDelKbn = new LinkedHashMap<String, String>();
        mapDelKbn.put("", "--なし--");
        for (SelectComboListEntity outEntity : outMainList) {
        	mapDelKbn.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
        }
        indto.setDelKbnCombo(mapDelKbn);

        //1-2-2			削除フラグ
		//コード情報から下記条件で値１：値１（漢字）を値１順に取得しドロップダウンリストを作成する
		//		コード名＝DEL_FLG（削除フラグ）
		//		削除フラグ=0
        inEntityCmb = new SelectComboListEntity();
    	inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_DEL_FLG);
        outMainList = dao.select(inEntityCmb);
        LinkedHashMap<String, String> mapDelFlg = new LinkedHashMap<String, String>();
        mapDelFlg.put("", "--なし--");
        for (SelectComboListEntity outEntity : outMainList) {
        	mapDelFlg.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
        }
        indto.setDelFlgCombo(mapDelFlg);

        //1-2-3			経営主体
		//施設_経営主体マスタから下記条件で武田経営主体コード：武田経営主体名を並び順昇順に取得しドロップダウンリストを作成する
		//		削除フラグ=0
        MRdmHcoKeieitaiEntiry inEntityKeieiCmb = new MRdmHcoKeieitaiEntiry("selectKeieitaiComboList");
        List<MRdmHcoKeieitaiEntiry> outMainKeieiList = dao.select(inEntityKeieiCmb);
        LinkedHashMap<String, String> mapKeieitai = new LinkedHashMap<String, String>();
        mapKeieitai.put("", "--なし--");
        for (MRdmHcoKeieitaiEntiry outEntity : outMainKeieiList) {
        	mapKeieitai.put(outEntity.getSetDtCd(), outEntity.getSetDtCd()+":"+outEntity.getKeieitaiKj());
        }
        indto.setKeieitaiCombo(mapKeieitai);

        //1-2-4			対象区分
		//コード情報から下記条件で値１：値１（漢字）を値１順に取得しドロップダウンリストを作成する
		//		コード名＝HO_INS_TYPE（対象区分）
		//		削除フラグ=0
        inEntityCmb = new SelectComboListEntity();
    	inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_HO_INS_TYPE);
        outMainList = dao.select(inEntityCmb);
        LinkedHashMap<String, String> mapHoInsType = new LinkedHashMap<String, String>();
        mapHoInsType.put("", "--なし--");
        for (SelectComboListEntity outEntity : outMainList) {
        	mapHoInsType.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
        }
        indto.setHoInsTypeCombo(mapHoInsType);

        //1-2-5			施設種別
		//コード情報から下記条件で値１：値１（漢字）を値１順に取得しドロップダウンリストを作成する
		//		コード名＝INS_TYPE（施設種別）
		//		削除フラグ=0
        inEntityCmb = new SelectComboListEntity();
    	inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_INS_TYPE);
        outMainList = dao.select(inEntityCmb);
        LinkedHashMap<String, String> mapInsType = new LinkedHashMap<String, String>();
        mapInsType.put("", "--なし--");
        for (SelectComboListEntity outEntity : outMainList) {
        	mapInsType.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
        }
        indto.setInsTypeCombo(mapInsType);

        //1-2-6			施設区分
		//コード情報から下記条件で値１：値１（漢字）を値１順に取得しドロップダウンリストを作成する
		//		コード名＝PHARM_TYPE（施設区分）
		//		削除フラグ=0
        inEntityCmb = new SelectComboListEntity();
    	inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_PHARM_TYPE);
        outMainList = dao.select(inEntityCmb);
        LinkedHashMap<String, String> mapPharmType = new LinkedHashMap<String, String>();
        mapPharmType.put("", "--なし--");
        for (SelectComboListEntity outEntity : outMainList) {
        	mapPharmType.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
        }
        indto.setPharmTypeCombo(mapPharmType);

        //1-2-7			都道府県
		//組織担当地区情報からJIS府県コード、JIS府県名を集約して取得しドロップダウンリストを作成する
		//※MR権限の場合、親画面．領域区分を検索条件とする
        SRdmJkrSosAddrEntity inEntityAddrCmb = new SRdmJkrSosAddrEntity("selectAddrPrefComboList");
		if(RdmConstantsData.RDM_JKN_MR.equals(indto.getLoginJokenSetCd())
				&& !StringUtils.isEmpty(indto.getTrtCd())) {
			//※MR権限の場合、親画面．領域区分を検索条件とする
			inEntityAddrCmb.setTrtCd(indto.getTrtCd());
		}
        List<SRdmJkrSosAddrEntity> outMainAddrList = dao.select(inEntityAddrCmb);
        LinkedHashMap<String, String> mapAddrPref = new LinkedHashMap<String, String>();
        mapAddrPref.put("", "--なし--");
        for (SRdmJkrSosAddrEntity outEntity : outMainAddrList) {
        	mapAddrPref.put(outEntity.getAddrCodePref(), outEntity.getAddrNamePref());
        }
        indto.setAddrPrefCombo(mapAddrPref);

        //1-2-8			JIS市区町村
		//ブランク　※都道府県が選択された場合、リストを取得する
        SRdmJkrSosAddrEntiry inEntityCityCmb = new SRdmJkrSosAddrEntiry("selectSRdmJkrCityNameEntiry");
        List<SRdmJkrSosAddrEntiry> outMainCityList = dao.select(inEntityCityCmb);
        LinkedHashMap<String, String> mapAddrCity = new LinkedHashMap<String, String>();
        mapAddrCity.put("", "--なし--");
        for (SRdmJkrSosAddrEntiry outEntity : outMainCityList) {
        	mapAddrCity.put(outEntity.getAddrCodePref()+outEntity.getAddrCodeCity(), outEntity.getAddrNameCity());
        }
        indto.setAddrCityCombo(mapAddrCity);
    }
}