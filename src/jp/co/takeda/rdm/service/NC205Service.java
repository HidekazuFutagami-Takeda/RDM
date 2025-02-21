/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.inject.Named;

import jp.co.takeda.rdm.common.BaseDTO;
import jp.co.takeda.rdm.common.BaseService;
import jp.co.takeda.rdm.common.BeanUtil;
import jp.co.takeda.rdm.dto.CatDeptsComboDataList;
//import jp.co.takeda.rdm.dto.NC204DTO;
import jp.co.takeda.rdm.dto.NC205DTO;
import jp.co.takeda.rdm.util.RdmConstantsData;
import jp.co.takeda.rdm.util.StringUtils;

import jp.co.takeda.rdm.entity.MRdmPostKouho;
//import jp.co.takeda.rdm.entity.join.SelectDeptListEntityRDM;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 * Serviceクラス（NC205)
 * @generated
 */
@Named
public class NC205Service extends BaseService {

    /**
     * ログインスタンス
     * @generated
     */
    private static Log log = LogFactory.getLog(NC205Service.class);

    /**
     * イベント処理
     * @param indto RDMNC205DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO init(NC205DTO indto) {
//        BaseDTO outdto = indto;
//
//        MRdmPostKouho testEntity = new MRdmPostKouho();
//
//        List<MRdmPostKouho> selectTestEntity = dao.select(testEntity);
//
//        indto.setTest(selectTestEntity.get(0).getTest());
//
//        // END UOC
//        return outdto;
        BaseDTO outdto = indto;
        // START UOC

        // ページ数(現在:１ページ目から)
        indto.setPageCntCur(1);

        //検索を行う
        outdto = search(indto);

        // END UOC
        return outdto;
    }
    /**
     * イベント処理
     * @param indto NC205DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO search(NC205DTO indto) {
        BaseDTO outdto = indto;
        // START UOC

        //一覧検索件数取得の検索条件の設定
       // SelectDeptListEntity paramEntity = new SelectDeptListEntity();
      MRdmPostKouho paramEntity = new MRdmPostKouho();
      	//paramEntity.setSeshonId("RDMND013");
      	//paramEntity.setScreenId("RDMND012");
      	paramEntity.setScreenId(indto.getScreenId());

        //親画面のみ入力_郵便番号 (パラメータ2)
        //paramEntity.setPostCode("3309545");//60600680293105//0293105//1050000
        paramEntity.setPostCode(indto.getPostCode());
        paramEntity.setPreScreenId(indto.getPreScreenId());
        if(paramEntity.getPostCode() != null) {

        List<CatDeptsComboDataList> catDeptsComboDataList = new ArrayList<CatDeptsComboDataList>();

            //画面初期表示時の帳票一覧を取得する
            List<MRdmPostKouho> selectTestEntity = dao.select(paramEntity);

            //RDM011とRDMND012はどちらも同じ処理だが、この書き方でのORがどうかけばよいかわかるまで分けて書いています。
            if(paramEntity.getPreScreenId().equals("ND011")) {
            	for (MRdmPostKouho entiry : selectTestEntity) {
                    CatDeptsComboDataList dataRecord = new CatDeptsComboDataList();

                    // 郵便番号
                    dataRecord.setPostCode(entiry.getPostCode());
                    // JIS府県名  1112
                    dataRecord.setAddrNamePref(entiry.getAddrNamePref());
                    // JIS市区町村名  1112
                    dataRecord.setAddrNameCity(entiry.getAddrNameCity());
                    // 大字／町域名 1112
                    dataRecord.setAddrNameArea(entiry.getAddrNameArea());
                    // JIS府県コード  1112
                    dataRecord.setAddrCodePref(entiry.getAddrCodePref());
                    // JIS市区町村コード  1112
                    dataRecord.setAddrCodeCity(entiry.getAddrCodeCity());
                    // 武田府県コード 1112
                    dataRecord.setTkPrefCd(entiry.getTkPrefCd());
                    // 武田市区郡コード 1112
                    dataRecord.setTkCityCd(entiry.getTkCityCd());

                    catDeptsComboDataList.add(dataRecord);
            	}
            }else if(paramEntity.getPreScreenId().equals("ND012")) {
            	for (MRdmPostKouho entiry : selectTestEntity) {
                    CatDeptsComboDataList dataRecord = new CatDeptsComboDataList();

                    // 郵便番号
                    dataRecord.setPostCode(entiry.getPostCode());
                    // JIS府県名  1112
                    dataRecord.setAddrNamePref(entiry.getAddrNamePref());
                    // JIS市区町村名  1112
                    dataRecord.setAddrNameCity(entiry.getAddrNameCity());
                    // 大字／町域名 1112
                    dataRecord.setAddrNameArea(entiry.getAddrNameArea());
                    // JIS府県コード  1112
                    dataRecord.setAddrCodePref(entiry.getAddrCodePref());
                    // JIS市区町村コード  1112
                    dataRecord.setAddrCodeCity(entiry.getAddrCodeCity());
                    // 武田府県コード 1112
                    dataRecord.setTkPrefCd(entiry.getTkPrefCd());
                    // 武田市区郡コード 1112
                    dataRecord.setTkCityCd(entiry.getTkCityCd());

                    catDeptsComboDataList.add(dataRecord);
            }
            }else if(paramEntity.getPreScreenId() != null) {
            	for (MRdmPostKouho entiry : selectTestEntity) {
                    CatDeptsComboDataList dataRecord = new CatDeptsComboDataList();

                    // 郵便番号
                    dataRecord.setPostCode(entiry.getPostCode());
                    // JIS府県名
                    dataRecord.setAddrNamePref(entiry.getAddrNamePref());
                    // JIS市区町村名
                    dataRecord.setAddrNameCity(entiry.getAddrNameCity());
                    // 大字／町域名
                    dataRecord.setAddrNameArea(entiry.getAddrNameArea());
                    // JIS府県コード
                    dataRecord.setAddrCodePref(entiry.getAddrCodePref());
                    // JIS市区町村コード
                    dataRecord.setAddrCodeCity(entiry.getAddrCodeCity());
                    // 武田府県コード
                    dataRecord.setTkPrefCd(entiry.getTkPrefCd());
                    // 武田市区郡コード
                    dataRecord.setTkCityCd(entiry.getTkCityCd());
                    // 武田市区郡名
                    dataRecord.setTkCityName(entiry.getTkCityName());
                    // JIS府県カナ
                    dataRecord.setAddrKanaPref(entiry.getAddrKanaPref() + entiry.getAddrKanaCity() +entiry.getAddrKanaArea());
                    // JIS市区町村名カナ
                    dataRecord.setAddrKanaCity(entiry.getAddrKanaCity());
                    // 大字／町域名カナ
                    dataRecord.setAddrKanaArea(entiry.getAddrKanaArea()); /*setDeptCode部分を修正している(DeptKn)*/

                    catDeptsComboDataList.add(dataRecord);
            	}
            }
           //郵便番号が７桁であるかの確認と内部は郵便番号が3-7になるようハイフンを付ける処理
           if(paramEntity.getPostCode().length() == 7) {
               indto.setPostCode(paramEntity.getPostCode().substring(0, 3)+ '-' + paramEntity.getPostCode().substring(3, 7));
           }

        //検索された帳票一覧をDTOに設定する
        indto.setCatDeptsComboDataList(catDeptsComboDataList);
        // END UOC
        }return outdto;
    }
}
