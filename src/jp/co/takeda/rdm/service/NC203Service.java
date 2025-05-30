/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import jp.co.takeda.rdm.util.RdmConstantsData;
import jp.co.takeda.rdm.util.StringUtils;

import javax.inject.Named;

import jp.co.takeda.rdm.common.BaseDTO;
import jp.co.takeda.rdm.common.BaseInfoHolder;
import jp.co.takeda.rdm.common.BaseService;
import jp.co.takeda.rdm.common.LoginInfo;
import jp.co.takeda.rdm.dto.NC203DTO;
import jp.co.takeda.rdm.dto.InsData;
import jp.co.takeda.rdm.entity.MRdmHcoKeieitaiEntiry;
import jp.co.takeda.rdm.entity.SRdmJkrSosAddrEntiry;
import jp.co.takeda.rdm.entity.join.MRdmCodeMstEntity;
import jp.co.takeda.rdm.entity.join.SelectCntSelectHcoEntity;
import jp.co.takeda.rdm.entity.join.SelectHenkanListEntity;
import jp.co.takeda.rdm.entity.join.SelectInsListEntity;
import jp.co.takeda.rdm.entity.join.SelectParamNc203Entity;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 * Serviceクラス（NC203)
 * @generated
 */
@Named
public class NC203Service extends BaseService {

    /**
     * ログインスタンス
     * @generated
     */
    private static Log log = LogFactory.getLog(NC203Service.class);

    /**
     * イベント処理
     * @param indto NC203DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO init(NC203DTO indto) {
        BaseDTO outdto = indto;
    	//1-1 権限判定
        LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();
        // START UOC
        //検索部分ヘッダ（初期表示は表示しない=1）
        indto.setPageFlg(1);

         //ページ数(現在:１ページ目から)
        indto.setPageCntCur(1);

        String backScreenId = indto.getBackScreenId();
        if(("NC209".equals(backScreenId) || "ND001".equals(backScreenId) )) {//医師検索は画面の組織を引き継ぐ
        	if(!StringUtils.isEmpty(indto.getParamSosCd())) {
        		indto.setSosCd(indto.getParamSosCd());
        		indto.setSosName(indto.getParamSosName());
        	}
    		if(!StringUtils.isEmpty(indto.getParamJgiNo())) {
	    		indto.setJgiNo(indto.getParamJgiNo());
	    		indto.setJgiName(indto.getParamJgiName());
    		}
        } else {
        	if(!("ND101".equals(backScreenId) || "ND103".equals(backScreenId) )) {//勤務先追加、医療機関異動はMRも無制限
        	// MR権限の場合検索条件．組織、検索条件．担当者設定する
        		if(RdmConstantsData.RDM_JKN_MR.equals(indto.getLoginJokenSetCd())) {
        			indto.setSosCd(loginInfo.getSosCd());
        			indto.setSosName(loginInfo.getBumonRyakuName());
        			indto.setJgiNo(Integer.toString(loginInfo.getJgiNo()));
        			indto.setJgiName(loginInfo.getJgiName());
        			indto.setLoginBrCd(loginInfo.getBrCode());
        			indto.setLoginDistCd(loginInfo.getDistCode());
        			indto.setTrtCd(loginInfo.getTrtCd());
        		}
        	}
        }

        outdto = this.list(indto);
        outdto = this.searchCityName(indto);

      //施設名(漢字)
//
//		  indto.setSosName("ＧＩ東海Ｒ	東海西Ａ"); //施設名(カナ) indto.setJgiName("大城　信雄");

        return outdto;
    }

    /**
     * イベント処理
     * @param indto NC203DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO search(NC203DTO indto) {
    	LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();
        BaseDTO outdto = indto;

        outdto = this.list(indto);
        outdto = this.searchCityName(indto);

		//
    	SelectInsListEntity selectinsListEntity = new SelectInsListEntity();
    	SelectCntSelectHcoEntity selectParamSelectHcoEntity = new SelectCntSelectHcoEntity();

    	selectinsListEntity.setViewKbn(indto.getViewKbn());
    	selectParamSelectHcoEntity.setViewKbn(indto.getViewKbn());
    	if(!"1".equals(indto.getViewKbn())) {
    		selectinsListEntity.setSqlId("selectInsList");
    		selectParamSelectHcoEntity.setSqlId("selectCntHco");
    	}

    	if(RdmConstantsData.RDM_JKN_ADMIN.equals(indto.getLoginJokenSetCd())) {
    		// 管理者権限
    		selectinsListEntity.setKnrFlg(true);
    		selectParamSelectHcoEntity.setKnrFlg(true);
    		/*
    		if(("NF211".equals(indto.getBackScreenId()) || "NF212".equals(indto.getBackScreenId()))
    				&& "1".equals(indto.getTkdTrtKbn()) && !indto.getTrtCd().isEmpty()){
    			selectinsListEntity.setTrtCd(indto.getTrtCd());
    			selectParamSelectHcoEntity.setTrtCd(indto.getTrtCd());
    		}
    		*/
    	} else {
    		String backScreenId = indto.getBackScreenId();
    		if(("ND101".equals(backScreenId) || "ND103".equals(backScreenId) )) {//勤務先追加、医療機関異動はMRも無制限
        		selectinsListEntity.setKnrFlg(true);
        		selectParamSelectHcoEntity.setKnrFlg(true);
    		} else {
    			// MR権限
    			selectinsListEntity.setKnrFlg(false);
    			selectParamSelectHcoEntity.setKnrFlg(false);
    			/*
    		if(!indto.getTrtCd().isEmpty()){
    			selectinsListEntity.setTrtCd(indto.getTrtCd());
    			selectParamSelectHcoEntity.setTrtCd(indto.getTrtCd());
    		}
    		selectinsListEntity.setJgiNo(indto.getLoginJgiNo());
    		selectParamSelectHcoEntity.setJgiNo(indto.getLoginJgiNo());
    		selectinsListEntity.setBrCd(indto.getLoginBrCd());
    		selectParamSelectHcoEntity.setBrCd(indto.getLoginBrCd());
    		selectinsListEntity.setDistCd(indto.getLoginDistCd());
    		selectParamSelectHcoEntity.setDistCd(indto.getLoginDistCd());
    			 */

    			selectinsListEntity.setSosCd(loginInfo.getSosCd());
    			selectinsListEntity.setSosRank(loginInfo.getBumonRank());
    			selectParamSelectHcoEntity.setSosCd(loginInfo.getSosCd());
    			selectParamSelectHcoEntity.setSosRank(loginInfo.getBumonRank());
    		}
    	}

        //MRで医師新規登録の勤務先施設、医療機関への異動の異動先施設、医師復活の復活先施設、勤務先追加が親画面の場合
        //または医師検索で組織が選択されている場合
        String backScreenId = indto.getBackScreenId();
//        if(RdmConstantsData.RDM_JKN_MR.equals(indto.getLoginJokenSetCd()) &&
//        		("ND011".equals(backScreenId) || "ND014".equals(backScreenId) || "ND101".equals(backScreenId) || "ND103".equals(backScreenId) )
//        ) {
        if(RdmConstantsData.RDM_JKN_MR.equals(indto.getLoginJokenSetCd()) &&
        		("ND011".equals(backScreenId) || "ND014".equals(backScreenId) )
        ) {
        	selectinsListEntity.setSosCd(indto.getSosCd());
        	selectinsListEntity.setSosRank(loginInfo.getBumonRank());
        	selectParamSelectHcoEntity.setSosCd(indto.getSosCd());
        	selectParamSelectHcoEntity.setSosRank(loginInfo.getBumonRank());
        }
        if(("NC209".equals(backScreenId) || "ND001".equals(backScreenId) )) {
        	selectinsListEntity.setSosCd(StringUtils.setEmptyToNull(indto.getSosCd()));
        	selectinsListEntity.setSosRank(StringUtils.setEmptyToNull(indto.getParamSosRank()));
        	selectParamSelectHcoEntity.setSosCd(StringUtils.setEmptyToNull(indto.getSosCd()));
        	selectParamSelectHcoEntity.setSosRank(StringUtils.setEmptyToNull(indto.getParamSosRank()));
        }

    	//検索条件_施設名（全角）
        if (indto.getInsKanjiSrch().isEmpty()) {
        	indto.setInsKanjiSrch(null);
        }
        else {
        	 //漢字変換
        	SelectHenkanListEntity kanjiHenkan = new SelectHenkanListEntity("漢字変換");
            kanjiHenkan.setSearchHenkan(indto.getInsKanjiSrch());
            //漢字変換結果を格納
            List<SelectHenkanListEntity> selectKanji = dao.select(kanjiHenkan);
            for (SelectHenkanListEntity kanji : selectKanji) {
            	selectinsListEntity.setInsKanjiSrch(kanji.getSearchHenkan());
            	selectParamSelectHcoEntity.setInsKanjiSrch(kanji.getSearchHenkan());
            }
        }

        //検索条件_施設名（半角カナ）
        if (indto.getInsKanaSrch().isEmpty()) {
        	indto.setInsKanaSrch(null);
        }
        else {
        	 //半角変換
        	SelectHenkanListEntity kanaHenkan = new SelectHenkanListEntity("半角変換");
            kanaHenkan.setSearchHenkan(indto.getInsKanaSrch());
            //半角変換結果を格納
            List<SelectHenkanListEntity> selectKana = dao.select(kanaHenkan);
            for (SelectHenkanListEntity kana : selectKana) {
            	selectinsListEntity.setInsKanaSrch(kana.getSearchHenkan());
            	selectParamSelectHcoEntity.setInsKanaSrch(kana.getSearchHenkan());
            }
        }

      //検索条件_電話番号
        if (indto.getPhone1().isEmpty()) {
        	indto.setPhone1(null);
        }
        else {
        	 //ハイフン除去
        	SelectHenkanListEntity haifunRemove = new SelectHenkanListEntity("ハイフン除去");
        	haifunRemove.setSearchHenkan(indto.getPhone1());
            //ハイフン除去結果を格納
            List<SelectHenkanListEntity> selectPhone = dao.select(haifunRemove);
            for (SelectHenkanListEntity phone : selectPhone) {
            	selectinsListEntity.setPhone1(phone.getSearchHenkan());
            	selectParamSelectHcoEntity.setPhone1(phone.getSearchHenkan());
            }
        }

        //検索条件_郵便番号
        if (indto.getInsPcode().isEmpty()) {
        	indto.setInsPcode(null);
        }
        else {
        	 //ハイフン除去
        	SelectHenkanListEntity haifunRemove = new SelectHenkanListEntity("ハイフン除去");
        	haifunRemove.setSearchHenkan(indto.getInsPcode());
            //ハイフン除去結果を格納
            List<SelectHenkanListEntity> selectPcode = dao.select(haifunRemove);
            for (SelectHenkanListEntity pcode : selectPcode) {
            	selectinsListEntity.setInsPcode(pcode.getSearchHenkan());
            	selectParamSelectHcoEntity.setInsPcode(pcode.getSearchHenkan());
            }
        }

        if(!StringUtils.isEmpty(indto.getKensakuAddrCodeCity())){
        	selectinsListEntity.setKensakuAddrCodeCity(StringUtils.setEmptyToNull(indto.getKensakuAddrCodeCity().substring(2)));
        	selectParamSelectHcoEntity.setKensakuAddrCodeCity(StringUtils.setEmptyToNull(indto.getKensakuAddrCodeCity().substring(2)));
  		}

		//1-4-1 件数定義取得
		SelectParamNc203Entity selectParamNc203Entity = new SelectParamNc203Entity();
		List<SelectParamNc203Entity> selectParamNc203List;
		selectParamNc203List = dao.select(selectParamNc203Entity);

		//1-4-2 件数取得
        List<SelectCntSelectHcoEntity> selectParamSelectHcoList;
//        String backScreenId = indto.getBackScreenId();

        // 廃院区分
//        if("ND011".equals(backScreenId) || "ND014".equals(backScreenId) || "ND101".equals(backScreenId)
//        		|| "ND103".equals(backScreenId) || "ND501".equals(backScreenId) || "NF011".equals(backScreenId)
//        		|| "NF012".equals(backScreenId) || "NF211".equals(backScreenId) || "NF212".equals(backScreenId)
//        		|| "NF401".equals(backScreenId) || "NF403".equals(backScreenId)) {
//        	selectParamSelectHcoEntity.setKensakuHaiinKbnNullFlg("1");
//        } else {
//        	selectinsListEntity.setKensakuHaiinKbnNullFlg("0");
    	selectParamSelectHcoEntity.setKensakuHaiinKbn(StringUtils.setEmptyToNull(indto.getKensakuHaiinKbn()));
//        }

        selectParamSelectHcoEntity.setKensakuDelFlg(StringUtils.setEmptyToNull(indto.getKensakuDelFlg()));
        selectParamSelectHcoEntity.setInsNoSrch(StringUtils.setEmptyToNull(indto.getInsNoSrch()));
        selectParamSelectHcoEntity.setUltNo(StringUtils.setEmptyToNull(indto.getUltNo()));
        selectParamSelectHcoEntity.setKensakuManageCd(StringUtils.setEmptyToNull(indto.getKensakuManageCd()));
        selectParamSelectHcoEntity.setKensakuHoInsType(StringUtils.setEmptyToNull(indto.getKensakuHoInsType()));
        selectParamSelectHcoEntity.setKensakuInsSbt(StringUtils.setEmptyToNull(indto.getKensakuInsSbt()));
        selectParamSelectHcoEntity.setPharmType(StringUtils.setEmptyToNull(indto.getPharmType()));
        selectParamSelectHcoEntity.setKensakuAddrCodePref(StringUtils.setEmptyToNull(indto.getKensakuAddrCodePref()));
        selectParamSelectHcoEntity.setAddress(StringUtils.setEmptyToNull(indto.getAddress()));
        selectParamSelectHcoEntity.setKoshisetsuCheck(BooleanUtils.isTrue(indto.getKoshisetsuCheck()));
        selectParamSelectHcoEntity.setInSortId(StringUtils.setEmptyToNull(indto.getSortCondition()));

        selectParamSelectHcoList = dao.select(selectParamSelectHcoEntity);

        if (checkInput(loginInfo, indto, selectParamSelectHcoEntity ,false)) {
        	return outdto;
        }

        indto.setPageCnt(selectParamSelectHcoList.get(0).getCntHco());
        indto.setMaxPageCnt(selectParamNc203List.get(0).getValue());
        if (checkSearchResults(loginInfo, indto, false)) {
        	return outdto;
        }

        indto.initPageInfo(indto.getPageCntCur(), selectParamSelectHcoList.get(0).getCntHco(), selectParamNc203List.get(1).getValue());

        selectinsListEntity.setInOffset(indto.getLineCntStart() - 1);
        selectinsListEntity.setInLimit(selectParamNc203List.get(1).getValue());

        //検索結果取得
//        if("ND011".equals(backScreenId) || "ND014".equals(backScreenId) || "ND101".equals(backScreenId)
//        		|| "ND103".equals(backScreenId) || "ND501".equals(backScreenId) || "NF011".equals(backScreenId)
//        		|| "NF012".equals(backScreenId) || "NF211".equals(backScreenId) || "NF212".equals(backScreenId)
//        		|| "NF401".equals(backScreenId) || "NF403".equals(backScreenId)) {
//        	selectinsListEntity.setKensakuHaiinKbnNullFlg("1");
//        } else {
//        	selectinsListEntity.setKensakuHaiinKbnNullFlg("0");
    	selectinsListEntity.setKensakuHaiinKbn(StringUtils.setEmptyToNull(indto.getKensakuHaiinKbn()));
//        }
        selectinsListEntity.setKensakuDelFlg(StringUtils.setEmptyToNull(indto.getKensakuDelFlg()));
        selectinsListEntity.setInsNoSrch(StringUtils.setEmptyToNull(indto.getInsNoSrch()));
        selectinsListEntity.setUltNo(StringUtils.setEmptyToNull(indto.getUltNo()));
        selectinsListEntity.setKensakuManageCd(StringUtils.setEmptyToNull(indto.getKensakuManageCd()));
        selectinsListEntity.setKensakuHoInsType(StringUtils.setEmptyToNull(indto.getKensakuHoInsType()));
        selectinsListEntity.setKensakuInsSbt(StringUtils.setEmptyToNull(indto.getKensakuInsSbt()));
        selectinsListEntity.setPharmType(StringUtils.setEmptyToNull(indto.getPharmType()));
        selectinsListEntity.setKensakuAddrCodePref(StringUtils.setEmptyToNull(indto.getKensakuAddrCodePref()));
        selectinsListEntity.setAddress(StringUtils.setEmptyToNull(indto.getAddress()));
        selectinsListEntity.setKoshisetsuCheck(BooleanUtils.isTrue(indto.getKoshisetsuCheck()));
        selectinsListEntity.setInSortId(StringUtils.setEmptyToNull(indto.getSortCondition()));

    	List<SelectInsListEntity> selectInsEntityList = dao.select(selectinsListEntity);

        List<InsData> dataList = new ArrayList<InsData>();
        for(SelectInsListEntity entity : selectInsEntityList) {

        	InsData test = new InsData();

        	// 施設略式漢字名
        	if(entity.getInsAbbrName() != null) {
        	test.setInsAbbrName(entity.getInsAbbrName());
        	}else {
        	test.setInsAbbrName(" ");
    		}

        	// 施設正式漢字名
        	if(entity.getInsFormalName() != null) {
        	test.setInsFormalName(entity.getInsFormalName());
        	}else {
        	test.setInsFormalName(" ");
    		}

        	// 施設固定コード
        	if(entity.getInsNo() != null) {
        	test.setInsNo(entity.getInsNo());
        	}else {
        	test.setInsNo(" ");
    		}

        	// 住所
        	if(entity.getInsAddr() != null) {
        	test.setInsAddr(entity.getInsAddr());
        	}else {
        	test.setInsAddr(" ");
    		}

        	// 電話名
        	if(entity.getPhone1() != null) {
        	test.setPhone1(entity.getPhone1());
        	}else {
        	test.setPhone1(" ");
    		}

        	// 施設種別
        	if(entity.getInsSbt() != null) {
        	test.setInsSbt(entity.getInsSbt());
        	}else {
        	test.setInsSbt("");
        	}

        	// 施設種別
        	if(entity.getInsSbtNm() != null) {
        	test.setInsSbtNm(entity.getInsSbtNm());
        	}else {
        	test.setInsSbtNm(" ");
        	}

        	// 経営主体コード
        	if(entity.getManageCd() != null) {
        	test.setManageCd(entity.getManageCd());
        	}else {
        	test.setManageCd("");
        	}

        	// 経営主体
        	if(entity.getManageNm() != null) {
        	test.setManageNm(entity.getManageNm());
        	}else {
        	test.setManageNm(" ");
        	}

        	// 病床数
        	test.setBedsTot(entity.getBedsTot());

        	// ULT施設略式漢字名
        	if(entity.getShisetsuNmRyaku() != null) {
        	test.setShisetsuNmRyaku(entity.getShisetsuNmRyaku());
        	}else {
        	test.setShisetsuNmRyaku(" ");
    		}

        	// ULT施設正式漢字名
        	if(entity.getShisetsuNm() != null) {
        	test.setShisetsuNm(entity.getShisetsuNm());
        	}else {
        	test.setShisetsuNm(" ");
    		}

        	// ULT施設固定コード
        	if(entity.getDcfShisetsuCd() != null) {
        	test.setDcfShisetsuCd(entity.getDcfShisetsuCd());
        	}else {
        	test.setDcfShisetsuCd(" ");
    		}

        	// ULT住所
        	if(entity.getAddress() != null) {
        	test.setAddress(entity.getAddress());
        	}else {
        	test.setAddress(" ");
    		}

        	// ULT電話番号
        	if(entity.getShisetsuTel() != null) {
        	test.setShisetsuTel(entity.getShisetsuTel());
        	}else {
        	test.setShisetsuTel(" ");
    		}

        	// 施設区分
        	if(entity.getShisetsuKbn() != null) {
        	test.setShisetsuKbn(entity.getShisetsuKbn());
        	}else {
        	test.setShisetsuKbn(" ");
    		}

        	// 施設区分
        	if(entity.getShisetsuKbnNm() != null) {
        	test.setShisetsuKbnNm(entity.getShisetsuKbnNm());
        	}else {
        	test.setShisetsuKbnNm(" ");
    		}

        	// 経営主体コード
        	if(entity.getKeieitaiCd() != null) {
        	test.setKeieitaiCd(entity.getKeieitaiCd());
        	}else {
        	test.setKeieitaiCd(" ");
    		}

        	// 経営主体
        	if(entity.getKeieitaiNm() != null) {
        	test.setKeieitaiNm(entity.getKeieitaiNm());
        	}else {
        	test.setKeieitaiNm(" ");
    		}

        	// 経営主体コード
        	if(entity.getKeieitaiCd() != null) {
        	test.setKeieitaiCd(entity.getKeieitaiCd());
        	}else {
        	test.setKeieitaiCd(" ");
    		}

        	// 病床数
        	test.setByoshoSu(entity.getByoshoSu());

        	// 郵便番号
        	if(entity.getInsPcode() != null) {
        	test.setInsPcode(entity.getInsPcode());
        	}else {
        	test.setInsPcode(" ");
    		}

        	// 氏名
        	if("0".equals(indto.getTkdTrtKbn())) {
        		test.setJgiName("");
        	} else {
        		test.setJgiName(entity.getJgiName());
        	}

        	// 対象区分
        	test.setHoInsType(entity.getHoInsType());

        	// 施設区分
        	test.setInsClass(entity.getInsClass());

        	// 施設名カナ
        	test.setShisetsuNmKana(entity.getShisetsuNmKana());
        	// 郵便番号
        	test.setYubinNo(entity.getYubinNo());
        	// 都道府県コード
        	test.setTodofukenCd(entity.getTodofukenCd());
        	// 都道府県名
        	test.setAddrNamePref(entity.getAddrNamePref());
        	// 市区町村コード
        	test.setShikuchosonCd(entity.getShikuchosonCd());
        	// 市区町村名
        	test.setAddrNameCity(entity.getAddrNameCity());
        	// 武田市区郡コード
        	test.setTkCityCd(entity.getTkCityCd());
        	// 武田市区郡名
        	test.setTkCityName(entity.getTkCityName());

        	//データ代入
        	dataList.add(test);
        }
        indto.setInsData(dataList);

      //検索部分ヘッダ（検索後は表示=0）
        indto.setPageFlg(0);

        // END UOC
        return outdto;
    }

    /**
     * イベント処理
     * @param indto NC203DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO list(NC203DTO indto) {
        BaseDTO outdto = indto;
        // START UOC
        String backScreenId = indto.getBackScreenId();

        // 廃院区分
        LinkedHashMap<String, String> mapHaiinKbn = new LinkedHashMap<String, String>();
        if("ND011".equals(backScreenId) || "ND014".equals(backScreenId) || "ND101".equals(backScreenId)
        		|| "ND103".equals(backScreenId) || "ND501".equals(backScreenId) || "NF011".equals(backScreenId)
        		|| "NF012".equals(backScreenId) || "NF211".equals(backScreenId) || "NF212".equals(backScreenId)
        		|| "NF401".equals(backScreenId) || "NF403".equals(backScreenId)) {
        	// 0固定
        	//廃院区分_生成用エンティティ
            MRdmCodeMstEntity paramHaiinKbn = new MRdmCodeMstEntity();
            //検索条件_廃院区分
            paramHaiinKbn.setCodeName("DEL_KBN");
            //廃院区分の帳票一覧を取得する
            List<MRdmCodeMstEntity> SelectHaiinKbn = dao.selectByValue(paramHaiinKbn);

		    for (MRdmCodeMstEntity outEntity : SelectHaiinKbn) {
		    	if("0".equals(outEntity.getValue1())) {
		    		mapHaiinKbn.put(outEntity.getValue1(), outEntity.getValue1Kanj());
		    	}
		    }
        	indto.setKensakuHaiinKbn("0");
        } else {
            //廃院区分_生成用エンティティ
            MRdmCodeMstEntity paramHaiinKbn = new MRdmCodeMstEntity();
            //検索条件_廃院区分
            paramHaiinKbn.setCodeName("DEL_KBN");
            //廃院区分の帳票一覧を取得する
            List<MRdmCodeMstEntity> SelectHaiinKbn = dao.selectByValue(paramHaiinKbn);

		    mapHaiinKbn.put("", "--なし--");
		    for (MRdmCodeMstEntity outEntity : SelectHaiinKbn) {
		    	mapHaiinKbn.put(outEntity.getValue1(), outEntity.getValue1Kanj());
		    }
        }
        indto.setHaiinKbnMap(mapHaiinKbn);

        //削除フラグ_生成用エンティティ
        MRdmCodeMstEntity paramDelFlg = new MRdmCodeMstEntity();
    	//検索条件_削除フラグ
        paramDelFlg.setCodeName("DEL_FLG");
        //削除フラグの帳票一覧を取得する
        List<MRdmCodeMstEntity> SelectDelFlg = dao.selectByValue(paramDelFlg);

        LinkedHashMap<String, String> mapDelFlg = new LinkedHashMap<String, String>();
        if("ND011".equals(backScreenId) || "ND014".equals(backScreenId) || "ND101".equals(backScreenId)
        		|| "ND103".equals(backScreenId) || "ND501".equals(backScreenId) || "NF011".equals(backScreenId)
        		|| "NF012".equals(backScreenId) || "NF211".equals(backScreenId) || "NF212".equals(backScreenId)
        		|| "NF401".equals(backScreenId) || "NF403".equals(backScreenId)) {
		    for (MRdmCodeMstEntity outEntity : SelectDelFlg) {
		    	if("0".equals(outEntity.getValue1())) {
		    		// 「0:無効」を選択し変更不可とする
		    		mapDelFlg.put(outEntity.getValue1(), outEntity.getValue1Kanj());
		    		indto.setKensakuDelFlg("0");
		    	}
		    }
        } else {
		    mapDelFlg.put("", "--なし--");
		    for (MRdmCodeMstEntity outEntity : SelectDelFlg) {
		    	mapDelFlg.put(outEntity.getValue1(), outEntity.getValue1Kanj());
		    }
        }
        indto.setDelFlgMap(mapDelFlg);


        //施設区分_生成用エンティティ
    	MRdmCodeMstEntity paramPharmType = new MRdmCodeMstEntity();
    	//検索条件_施設区分
    	paramPharmType.setCodeName("PHARM_TYPE");
        //施設区分の帳票一覧を取得する
        List<MRdmCodeMstEntity> SelectPharmTypeList = dao.selectByValue(paramPharmType);
        //施設区分データ_取り出す
        LinkedHashMap<String, String> mapPharmType = new LinkedHashMap<String, String>();
        mapPharmType.put("", "--なし--");
        for (MRdmCodeMstEntity outEntity : SelectPharmTypeList) {
        	mapPharmType.put(outEntity.getValue1(), outEntity.getValue1Kanj());
        }
        //施設区分を格納する
        indto.setPharmTypeMap(mapPharmType);

        //検索条件_施設種別
    	paramPharmType.setCodeName("INS_TYPE");
        //施設種別の帳票一覧を取得する
        List<MRdmCodeMstEntity> SelectInsTypeList = dao.selectByValue(paramPharmType);
        //施設種別データ_取り出す
        LinkedHashMap<String, String> mapInsTypeList = new LinkedHashMap<String, String>();

        if("0".equals(indto.getInsSbtEditFlg())) {
        	// 連携された施設種別を選択状態とし変更不可とする
        	for (MRdmCodeMstEntity outEntity : SelectInsTypeList) {
        		if(indto.getKensakuInsSbt().equals(outEntity.getValue1())) {
        			mapInsTypeList.put(outEntity.getValue1(), outEntity.getValue1Kanj());
        		}
		    }

        } else {
		    mapInsTypeList.put("", "--なし--");
		    for (MRdmCodeMstEntity outEntity : SelectInsTypeList) {
		    	mapInsTypeList.put(outEntity.getValue1(), outEntity.getValue1Kanj());
		    }
        }
        //施設種別を格納する
        indto.setInsTypeMap(mapInsTypeList);

        //対象区分_施設種別
    	paramPharmType.setCodeName("HO_INS_TYPE");
        //対象区分の帳票一覧を取得する
        List<MRdmCodeMstEntity> SelectHoInsTypeList = dao.selectByValue(paramPharmType);
        //対象区分データ_取り出す
        LinkedHashMap<String, String> mapHoInsType = new LinkedHashMap<String, String>();
        mapHoInsType.put("", "--なし--");
        for (MRdmCodeMstEntity outEntity : SelectHoInsTypeList) {
        	mapHoInsType.put(outEntity.getValue1(), outEntity.getValue1Kanj());
        }
        //対象区分を格納する
        indto.setHoInsTypeMap(mapHoInsType);

        //経営主体_生成用エンティティ
        MRdmHcoKeieitaiEntiry paramHcoKeieitai = new MRdmHcoKeieitaiEntiry();
        //経営主体の帳票一覧を取得する
        List<MRdmHcoKeieitaiEntiry> SelectHcoKeieitai = dao.select(paramHcoKeieitai);

        LinkedHashMap<String, String> mapHcoKeieitai = new LinkedHashMap<String, String>();
        mapHcoKeieitai.put("", "--なし--");
        for (MRdmHcoKeieitaiEntiry outEntity : SelectHcoKeieitai) {
        	mapHcoKeieitai.put(outEntity.getSetDtCd(), outEntity.getKeieitaiKj());
        }
        indto.setHcoKeieitaiMap(mapHcoKeieitai);

        //都道府県_組織担当地区情報_生成用エンティティ
        SRdmJkrSosAddrEntiry paramJkrSosAddr = new SRdmJkrSosAddrEntiry();
        //MRで医師新規登録の勤務先施設、医療機関への異動の異動先施設、医師復活の復活先施設、勤務先追加が親画面の場合
        //または医師検索で組織が選択されている場合
        if(RdmConstantsData.RDM_JKN_MR.equals(indto.getLoginJokenSetCd()) &&
        		("ND011".equals(backScreenId) || "ND014".equals(backScreenId) || "ND101".equals(backScreenId) || "ND103".equals(backScreenId) )
        ) {
        	paramJkrSosAddr.setInSosCd(indto.getSosCd());
        	LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();
        	paramJkrSosAddr.setInSosRank(loginInfo.getBumonRank());
        }
        if(("NC209".equals(backScreenId) || "ND001".equals(backScreenId) )) {
        	paramJkrSosAddr.setInSosCd(StringUtils.setEmptyToNull(indto.getSosCd()));
        	paramJkrSosAddr.setInSosRank(StringUtils.setEmptyToNull(indto.getParamSosRank()));
        }
        //都道府県_都道府県_組織担当地区情報の帳票一覧を取得する
        List<SRdmJkrSosAddrEntiry> SelectJkrSosAddr = dao.select(paramJkrSosAddr);
        //都道府県_組織担当地区情報データ_取り出す
        LinkedHashMap<String, String> mapJkrSosAddr = new LinkedHashMap<String, String>();
        mapJkrSosAddr.put("", "--なし--");
        for (SRdmJkrSosAddrEntiry outEntity : SelectJkrSosAddr) {
        	mapJkrSosAddr.put(outEntity.getAddrCodePref(), outEntity.getAddrNamePref());
        }
        indto.setJkrSosAddrMap(mapJkrSosAddr);

        // END UOC
        return outdto;
    }

    /**
     * イベント処理
     * @param dto NF501DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO searchCityName(NC203DTO indto) {
    	BaseDTO outdto = indto;

    	//市区町村_組織担当地区情報_生成用エンティティ
        SRdmJkrSosAddrEntiry paramJkrCityName = new SRdmJkrSosAddrEntiry("");
        //MRで医師新規登録の勤務先施設、医療機関への異動の異動先施設、医師復活の復活先施設、勤務先追加が親画面の場合
        //または医師検索で組織が選択されている場合
        String backScreenId = indto.getBackScreenId();
        if(RdmConstantsData.RDM_JKN_MR.equals(indto.getLoginJokenSetCd()) &&
        		("ND011".equals(backScreenId) || "ND014".equals(backScreenId) || "ND101".equals(backScreenId) || "ND103".equals(backScreenId) )
        ) {
        	paramJkrCityName.setInSosCd(indto.getSosCd());
        	LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();
        	paramJkrCityName.setInSosRank(loginInfo.getBumonRank());
        }
        if(("NC209".equals(backScreenId) || "ND001".equals(backScreenId) )) {
        	paramJkrCityName.setInSosCd(StringUtils.setEmptyToNull(indto.getSosCd()));
        	paramJkrCityName.setInSosRank(StringUtils.setEmptyToNull(indto.getParamSosRank()));
        }
        //市区町村_都道府県_組織担当地区情報の帳票一覧を取得する
        List<SRdmJkrSosAddrEntiry> SelectJkrCityName = dao.select(paramJkrCityName);
        //市区町村_組織担当地区情報データ_取り出す
        LinkedHashMap<String, String> mapCityName = new LinkedHashMap<String, String>();
        mapCityName.put("", "--なし--");
        for (SRdmJkrSosAddrEntiry outEntity : SelectJkrCityName) {
        	//JIS府県コードとJIS市区町村コードを結合
        	String ketugouCd = outEntity.getAddrCodePref() + outEntity.getAddrCodeCity();
        	mapCityName.put(ketugouCd, outEntity.getAddrNameCity());
        }
        indto.setMapCityName(mapCityName);


        return outdto;
    }
    /**
     * イベント処理
     * @param indto NC203DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO sort(NC203DTO indto) {
        BaseDTO outdto = indto;
        // START UOC

        //検索を行う
        outdto = search(indto);

        // END UOC
        return outdto;
    }

    /*
	 * エラーありならtrueとし、エラーメッセージをmsgStrにセットする
	 */


	/*
	 * １：必須入力チェック
	 * エラーありならtrueとし、エラーメッセージをmsgStrにセットする
	 */
	public boolean checkInput(LoginInfo loginInfo, NC203DTO indto, SelectCntSelectHcoEntity selectParamSelectHcoEntity, boolean fullchkFlg) {

		boolean errChk = false;
		String msgStr = "";
		String tmpMsgStr = "";

        if (    StringUtils.isEmpty(selectParamSelectHcoEntity.getInsKanjiSrch())    &&
        		StringUtils.isEmpty(selectParamSelectHcoEntity.getInsKanaSrch())     &&
        		StringUtils.isEmpty(selectParamSelectHcoEntity.getKensakuHaiinKbn())      &&
        		StringUtils.isEmpty(selectParamSelectHcoEntity.getKensakuDelFlg())        &&
        		StringUtils.isEmpty(selectParamSelectHcoEntity.getInsNoSrch())    &&
        		StringUtils.isEmpty(selectParamSelectHcoEntity.getUltNo()) &&
        		StringUtils.isEmpty(selectParamSelectHcoEntity.getKensakuManageCd())       &&
        		StringUtils.isEmpty(selectParamSelectHcoEntity.getKensakuHoInsType())     &&
        		StringUtils.isEmpty(selectParamSelectHcoEntity.getKensakuInsSbt())        &&
        		StringUtils.isEmpty(selectParamSelectHcoEntity.getPharmType())    &&
        		StringUtils.isEmpty(selectParamSelectHcoEntity.getPhone1()) &&
        		StringUtils.isEmpty(selectParamSelectHcoEntity.getInsPcode())     &&
        		StringUtils.isEmpty(selectParamSelectHcoEntity.getKensakuAddrCodePref())     &&
        		StringUtils.isEmpty(selectParamSelectHcoEntity.getKensakuAddrCodeCity())    &&
        		StringUtils.isEmpty(selectParamSelectHcoEntity.getAddress())  &&
        		BooleanUtils.isFalse(selectParamSelectHcoEntity.isKoshisetsuCheck())        &&
        		StringUtils.isEmpty(selectParamSelectHcoEntity.getInSortId())
        		) {
			errChk = true;
			tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W001);// 検索条件を入力してください。
			msgStr = msgStr + tmpMsgStr + "\n";

        }
		if (errChk) {// エラーありなのでメッセージをセットする
			indto.setMsgStr(msgStr);
		}
        return errChk;
	}

	/*
	 * ６：範囲チェック　
	 * 検索結果件数
	 * エラーありならtrueとし、エラーメッセージをmsgStrにセットする
	 */
	public boolean checkSearchResults(LoginInfo loginInfo, NC203DTO indto, boolean fullchkFlg) {

		boolean errChk = false;
		String msgStr = "";
		String tmpMsgStr = "";

		//６：範囲チェック　
		//検索結果件数
		int pageCnt = 0;
		int maxPageCnt = 0;
		pageCnt = indto.getPageCnt();
		maxPageCnt = indto.getMaxPageCnt();
		if (pageCnt > maxPageCnt) {
			errChk = true;
			tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W002);// 検索結果が表示上限を超えています。検索条件を絞って再検索してください。
			msgStr = msgStr + tmpMsgStr + "\n";
		}
		if (errChk) {// エラーありなのでメッセージをセットする
			indto.setMsgStr(msgStr);
		}
		return errChk;
	}



    /**
     * イベント処理
     * @param indto NC203DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO page(NC203DTO indto) {
        BaseDTO outdto = indto;
        // START UOC

        outdto = search(indto);

        // END UOC
        return outdto;
    }

    /**
     * イベント処理
     * @param indto NC203DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO reset(NC203DTO indto) {
        BaseDTO outdto = indto;
        // START UOC

        //検索を行う
        outdto = init(indto);

        // END UOC
        return outdto;
    }

}
