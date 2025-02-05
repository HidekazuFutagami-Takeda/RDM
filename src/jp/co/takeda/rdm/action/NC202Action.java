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
//import jp.co.takeda.rdm.dto.NC201DTO;
import jp.co.takeda.rdm.dto.NC202DTO;
import jp.co.takeda.rdm.service.NC202Service;
import jp.co.takeda.rdm.util.AppConstant;
import jp.co.takeda.rdm.util.RdmConstantsData;
import jp.co.takeda.jkr.util.JkrConstantsData;

/**
 * Actionクラス
 * @generated
 */
@Named("nC202Action")
@Scope("request")
public class NC202Action extends BaseAction<NC202DTO> {

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
    private NC202Service nC202Service;

    // START UOC

    // END UOC

    /**
     * コンストラクタ
     * @generated
     */
    public NC202Action() {
        dto = new NC202DTO();
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
     * 業務処理
     * @customizable
     */
    public String init() throws Exception {
        initSetup();
        // F層呼び出し
        BaseDTO outdto = nC202Service.init(dto);
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
        sessionMap.put(AppConstant.SESKEY_NC202_SEARCHKEY, outdto);
        // END UOC
        setNextDTO(outdto);
        return outdto.getForward();
    }

    /**
     * 業務処理
     * @customizable
     */
    @InputConfig(methodName="validationError")
    public String ajaxJgi() throws Exception {
        ajaxSosSetup();
        // F層呼び出し
        BaseDTO outdto = nC202Service.ajaxJgi(dto);
        return ajaxSosJgiNext(outdto);
    }

    /**
     * 前処理
     * @customizable
     */
    protected void ajaxSosSetup() throws Exception {
        // START UOC
        NC202DTO searchKey = (NC202DTO)sessionMap.get(AppConstant.SESKEY_NC202_SEARCHKEY);

//        // ajaxのパラメータ退避
//        String searchTrtCd = dto.getTrtCdPop();
        Integer searchBumonRank= dto.getBumonRankPop();
        String searchSosCd = dto.getSosCdPop();

        BeanUtil.copyProperties(dto, searchKey);

        // Integer項目nullの場合、BeanUtil.copyPropertiesで0に変換されてしまうため、再設定
        //dto.setBumonRankPop(searchBumonRank);

        // 退避値の再設定

//        dto.setTrtCdPop(searchTrtCd);
        dto.setBumonRankPop(searchBumonRank);
        dto.setSosCdPop(searchSosCd);

        // END UOC
    }

    /**
     * 後処理
     * @customizable
     */
    protected String ajaxSosJgiNext(BaseDTO outdto) throws Exception {
        // START UOC
        outdto.setForward(RdmConstantsData.SCREEN_ID_NC202_2);
        // END UOC
        setNextDTO(outdto);
        return outdto.getForward();
    }
}
