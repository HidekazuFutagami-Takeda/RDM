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
            }
        }

		//1-4-1 件数定義取得
		SelectParamNc203Entity selectParamNc203Entity = new SelectParamNc203Entity();
		List<SelectParamNc203Entity> selectParamNc203List;
		selectParamNc203List = dao.select(selectParamNc203Entity);

		//1-4-2 件数取得
        SelectCntSelectHcoEntity selectParamSelectHcoEntity = new SelectCntSelectHcoEntity();
        List<SelectCntSelectHcoEntity> selectParamSelectHcoList;
        selectParamSelectHcoEntity.setInsKanjiSrch(StringUtils.setEmptyToNull(indto.getInsKanjiSrch()));
        selectParamSelectHcoEntity.setInsKanaSrch(StringUtils.setEmptyToNull(indto.getInsKanaSrch()));
        selectParamSelectHcoEntity.setKensakuHaiinKbn(StringUtils.setEmptyToNull(indto.getKensakuHaiinKbn()));
        selectParamSelectHcoEntity.setKensakuDelFlg(StringUtils.setEmptyToNull(indto.getKensakuDelFlg()));
        selectParamSelectHcoEntity.setInsNoSrch(StringUtils.setEmptyToNull(indto.getInsNoSrch()));
        selectParamSelectHcoEntity.setUltNo(StringUtils.setEmptyToNull(indto.getUltNo()));
        selectParamSelectHcoEntity.setKensakuManageCd(StringUtils.setEmptyToNull(indto.getKensakuManageCd()));
        selectParamSelectHcoEntity.setKensakuHoInsType(StringUtils.setEmptyToNull(indto.getKensakuHoInsType()));
        selectParamSelectHcoEntity.setKensakuInsSbt(StringUtils.setEmptyToNull(indto.getKensakuInsSbt()));
        selectParamSelectHcoEntity.setPharmType(StringUtils.setEmptyToNull(indto.getPharmType()));
        selectParamSelectHcoEntity.setPhone1(indto.getPhone1());
        selectParamSelectHcoEntity.setInsPcode(StringUtils.setEmptyToNull(indto.getInsPcode()));
        selectParamSelectHcoEntity.setKensakuAddrCodePref(StringUtils.setEmptyToNull(indto.getKensakuAddrCodePref()));
        selectParamSelectHcoEntity.setKensakuAddrCodeCity(StringUtils.setEmptyToNull(indto.getKensakuAddrCodeCity()));
        selectParamSelectHcoEntity.setAddress(StringUtils.setEmptyToNull(indto.getAddress()));
        selectParamSelectHcoEntity.setKoshisetsuCheck(BooleanUtils.isTrue(indto.getKoshisetsuCheck()));
        selectParamSelectHcoEntity.setInSortId(StringUtils.setEmptyToNull(indto.getSortCondition()));

        selectParamSelectHcoList = dao.select(selectParamSelectHcoEntity);

        if (checkInput(loginInfo, indto, selectParamSelectHcoEntity ,false)) {
        	return outdto;
        }

        indto.setPageCnt(selectParamSelectHcoList.get(0).getCntHco());
        indto.setMaxPageCnt(selectParamNc203List.get(0).getValue());
        indto.initPageInfo(indto.getPageCntCur(), selectParamSelectHcoList.get(0).getCntHco(), selectParamNc203List.get(1).getValue());
        if (checkSearchResults(loginInfo, indto, false)) {
        	return outdto;
        }

        selectinsListEntity.setInOffset(indto.getLineCntStart() - 1);
        selectinsListEntity.setInLimit(selectParamNc203List.get(1).getValue());

        //検索結果取得
        selectinsListEntity.setInsKanjiSrch(indto.getInsKanjiSrch());
        selectinsListEntity.setInsKanaSrch(StringUtils.setEmptyToNull(indto.getInsKanaSrch()));
        selectinsListEntity.setKensakuHaiinKbn(StringUtils.setEmptyToNull(indto.getKensakuHaiinKbn()));
        selectinsListEntity.setKensakuDelFlg(StringUtils.setEmptyToNull(indto.getKensakuDelFlg()));
        selectinsListEntity.setInsNoSrch(StringUtils.setEmptyToNull(indto.getInsNoSrch()));
        selectinsListEntity.setUltNo(StringUtils.setEmptyToNull(indto.getUltNo()));
        selectinsListEntity.setKensakuManageCd(StringUtils.setEmptyToNull(indto.getKensakuManageCd()));
        selectinsListEntity.setKensakuHoInsType(StringUtils.setEmptyToNull(indto.getKensakuHoInsType()));
        selectinsListEntity.setKensakuInsSbt(StringUtils.setEmptyToNull(indto.getKensakuInsSbt()));
        selectinsListEntity.setPharmType(StringUtils.setEmptyToNull(indto.getPharmType()));
        selectinsListEntity.setPhone1(indto.getPhone1());
        selectinsListEntity.setInsPcode(StringUtils.setEmptyToNull(indto.getInsPcode()));
        selectinsListEntity.setKensakuAddrCodePref(StringUtils.setEmptyToNull(indto.getKensakuAddrCodePref()));
        selectinsListEntity.setKensakuAddrCodeCity(StringUtils.setEmptyToNull(indto.getKensakuAddrCodeCity()));
        selectinsListEntity.setAddress(StringUtils.setEmptyToNull(indto.getAddress()));
        selectinsListEntity.setKoshisetsuCheck(BooleanUtils.isTrue(indto.getKoshisetsuCheck()));
        selectinsListEntity.setInSortId(StringUtils.setEmptyToNull(indto.getSortCondition()));

    	List<SelectInsListEntity> selectInsEntityList = dao.select(selectinsListEntity);

        List<InsData> dataList = new ArrayList<InsData>();
        for(SelectInsListEntity entiry : selectInsEntityList) {

        	InsData test = new InsData();

        	// 施設略式漢字名
        	test.setInsAbbrName(entiry.getInsAbbrName());

        	// 施設正式漢字名
        	test.setInsFormalName(entiry.getInsFormalName());

        	// 施設固定コード
        	test.setInsNo(entiry.getInsNo());

        	// 住所
        	test.setInsAddr(entiry.getInsAddr());

        	// 電話名
        	if(entiry.getPhone1() != null) {
        	test.setPhone1(entiry.getPhone1());
        	}else {
        	test.setPhone1(" ");
    		}

        	// 施設種別
        	if(entiry.getInsSbt() != null) {
        	test.setInsSbt(entiry.getInsSbt());
        	}else {
        	test.setInsSbt(" ");
        	}

        	// 経営主体コード
        	test.setManageCd(entiry.getManageCd());

        	// 病床数
        	test.setBedsTot(entiry.getBedsTot());

        	// ULT施設略式漢字名
        	if(entiry.getShisetsuNmRyaku() != null) {
        	test.setShisetsuNmRyaku(entiry.getShisetsuNmRyaku());
        	}else {
        	test.setShisetsuNmRyaku(" ");
    		}

        	// ULT施設正式漢字名
        	if(entiry.getShisetsuNm() != null) {
        	test.setShisetsuNm(entiry.getShisetsuNm());
        	}else {
        	test.setShisetsuNm(" ");
    		}

        	// ULT施設固定コード
        	if(entiry.getDcfShisetsuCd() != null) {
        	test.setDcfShisetsuCd(entiry.getDcfShisetsuCd());
        	}else {
        	test.setDcfShisetsuCd(" ");
    		}

        	// ULT住所
        	if(entiry.getAddress() != null) {
        	test.setAddress(entiry.getAddress());
        	}else {
        	test.setAddress(" ");
    		}

        	// ULT電話番号
        	if(entiry.getShisetsuTel() != null) {
        	test.setShisetsuTel(entiry.getShisetsuTel());
        	}else {
        	test.setShisetsuTel(" ");
    		}

        	// 施設区分
        	if(entiry.getShisetsuKbn() != null) {
        	test.setShisetsuKbn(entiry.getShisetsuKbn());
        	}else {
        	test.setShisetsuKbn(" ");
    		}

        	// 経営主体コード
        	if(entiry.getKeieitaiCd() != null) {
        	test.setKeieitaiCd(entiry.getKeieitaiCd());
        	}else {
        	test.setKeieitaiCd(" ");
    		}

        	// 病床数
        	test.setByoshoSu(entiry.getByoshoSu());

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

        //廃院区分_生成用エンティティ
        MRdmCodeMstEntity paramHaiinKbn = new MRdmCodeMstEntity();
        //検索条件_廃院区分
        paramHaiinKbn.setCodeName("DEL_KBN");
        //廃院区分の帳票一覧を取得する
        List<MRdmCodeMstEntity> SelectHaiinKbn = dao.select(paramHaiinKbn);

        LinkedHashMap<String, String> mapHaiinKbn = new LinkedHashMap<String, String>();
        mapHaiinKbn.put("", "--なし--");
        for (MRdmCodeMstEntity outEntity : SelectHaiinKbn) {
        	mapHaiinKbn.put(outEntity.getValue1(), outEntity.getValue1Kanj());
        }
        indto.setHaiinKbnMap(mapHaiinKbn);

        //削除フラグ_生成用エンティティ
        MRdmCodeMstEntity paramDelFlg = new MRdmCodeMstEntity();
    	//検索条件_削除フラグ
        paramDelFlg.setCodeName("DEL_FLG");
        //削除フラグの帳票一覧を取得する
        List<MRdmCodeMstEntity> SelectDelFlg = dao.select(paramDelFlg);

        LinkedHashMap<String, String> mapDelFlg = new LinkedHashMap<String, String>();
        mapDelFlg.put("", "--なし--");
        for (MRdmCodeMstEntity outEntity : SelectDelFlg) {
        	mapDelFlg.put(outEntity.getValue1(), outEntity.getValue1Kanj());
        }
        indto.setDelFlgMap(mapDelFlg);


        //施設区分_生成用エンティティ
    	MRdmCodeMstEntity paramPharmType = new MRdmCodeMstEntity();
    	//検索条件_施設区分
    	paramPharmType.setCodeName("PHARM_TYPE");
        //施設区分の帳票一覧を取得する
        List<MRdmCodeMstEntity> SelectPharmTypeList = dao.select(paramPharmType);
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
        List<MRdmCodeMstEntity> SelectInsTypeList = dao.select(paramPharmType);
        //施設種別データ_取り出す
        LinkedHashMap<String, String> mapInsTypeList = new LinkedHashMap<String, String>();
        mapInsTypeList.put("", "--なし--");
        for (MRdmCodeMstEntity outEntity : SelectInsTypeList) {
        	mapInsTypeList.put(outEntity.getValue1(), outEntity.getValue1Kanj());
        }
        //施設種別を格納する
        indto.setInsTypeMap(mapInsTypeList);

        //対象区分_施設種別
    	paramPharmType.setCodeName("HO_INS_TYPE");
        //対象区分の帳票一覧を取得する
        List<MRdmCodeMstEntity> SelectHoInsTypeList = dao.select(paramPharmType);
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
