/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.action;

import javax.inject.Inject;
import javax.inject.Named;

import com.opensymphony.xwork2.interceptor.annotations.Before;
import com.opensymphony.xwork2.interceptor.annotations.BeforeResult;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

import org.springframework.context.annotation.Scope;

import jp.co.takeda.rdm.common.BaseAction;
import jp.co.takeda.rdm.common.BaseDTO;
import jp.co.takeda.rdm.common.BeanUtil;
import jp.co.takeda.rdm.dto.NC201DTO;
import jp.co.takeda.rdm.service.NC201Service;
import jp.co.takeda.rdm.util.AppConstant;
//import jp.co.takeda.rdm.util.JkrConstantsData;
import jp.co.takeda.rdm.util.RdmConstantsData;

/**
 * Actionクラス
 * @generated
 */
@Named("nC201Action")
@Scope("request")
public class NC201Action extends BaseAction<NC201DTO> {

    /**
     * シリアルバージョンID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * Serviceオブジェクト
     * @generated
     */
    @Inject
    private NC201Service nC201Service;

    // START UOC

    // END UOC

    /**
     * コンストラクタ
     * @generated
     */
    public NC201Action() {
        dto = new NC201DTO();
    }

    /**
     * イベント毎のメソッド実行前に共通後処理。<br/>
     * 但し、validationエラー時は実行されない。
     * @return 遷移先（nullの場合、イベントのメソッドを呼び出す）
     * @customizable
     */
    @Before
    public String before() throws Exception {
        // START UOC
        return null;
        // END UOC
    }

    /**
     * イベント毎のメソッド実行前に共通後処理。<br/>
     * 但し、validationエラー時は実行されない。
     * @customizable
     */
    @BeforeResult
    public void beforeResult() throws Exception {
        // START UOC

        // END UOC
    }

    /**
     * validationエラー時に実行する処理。<br/>
     * @customizable
     */
    @InputConfig
    public String validationError() {
        // START UOC
        return "input";
        // END UOC
    }
    /**
     * 業務処理
     * @customizable
     */
    public String init() throws Exception {
        initSetup();
        // F層呼び出し
        BaseDTO outdto = nC201Service.init(dto);
        return initNext(outdto);
    }

    /**
     * 前処理
     * @customizable
     */
    protected void initSetup() throws Exception {
        // START UOC

        // END UOC
    }

    /**
     * 後処理
     * @customizable
     */
    protected String initNext(BaseDTO outdto) throws Exception {
        // START UOC
        // 検索条件をセッションに格納する（更新やソートリンク押下時に使用）
        sessionMap.put(AppConstant.SESKEY_NC201_SEARCHKEY, outdto);
        // END UOC
        setNextDTO(outdto);
        return outdto.getForward();
    }

    /**
     * 業務処理
     * @customizable
     */
    @InputConfig(methodName="validationError")
    public String ajaxSos() throws Exception {
        ajaxSosSetup();
        // F層呼び出し
        BaseDTO outdto = nC201Service.ajaxSos(dto);
        return ajaxSosJgiNext(outdto);
    }

    /**
     * 前処理
     * @customizable
     */
    protected void ajaxSosSetup() throws Exception {
        // START UOC
        NC201DTO searchKey = (NC201DTO)sessionMap.get(AppConstant.SESKEY_NC201_SEARCHKEY);

        // ajaxのパラメータ退避
        String searchTrtCd = dto.getTrtCdPop();
        Integer searchBumonRank= dto.getBumonRankPop();
        String searchSosCd = dto.getSosCdPop();

        BeanUtil.copyProperties(dto, searchKey);

        // Integer項目nullの場合、BeanUtil.copyPropertiesで0に変換されてしまうため、再設定
        //dto.setBumonRankPop(searchBumonRank);

        // 退避値の再設定

        dto.setTrtCdPop(searchTrtCd);
        dto.setBumonRankPop(searchBumonRank);
        dto.setSosCdPop(searchSosCd);

        // END UOC
    }

    /**
     * 後処理
     * @customizable
     */
    protected String ajaxSosJgiNext(BaseDTO outdto) throws Exception {
        outdto.setForward(RdmConstantsData.SCREEN_ID_NC201_2);
        setNextDTO(outdto);
        return outdto.getForward();
    }
}
