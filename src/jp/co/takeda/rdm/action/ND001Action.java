/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.action;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.interceptor.annotations.Before;
import com.opensymphony.xwork2.interceptor.annotations.BeforeResult;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

import jp.co.takeda.rdm.common.BaseAction;
import jp.co.takeda.rdm.common.BaseDTO;
import jp.co.takeda.rdm.common.BeanUtil;
import jp.co.takeda.rdm.dto.ND001DTO;
import jp.co.takeda.rdm.service.ND001Service;
import jp.co.takeda.rdm.util.RdmConstantsData;
import jp.co.takeda.rdm.util.StringUtils;
import lombok.Getter;
import lombok.Setter;

/**
 * Actionクラス
 * @generated
 */
@Named("nD001Action")
@Scope("request")
public class ND001Action extends BaseAction<ND001DTO> {

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
    private ND001Service nD001Service;

    /**
     * コンストラクタ
     * @generated
     */
    public ND001Action() {
        dto = new ND001DTO();
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
        BaseDTO outdto = nD001Service.init(dto);
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

        // END UOC
        setNextDTO(outdto);
        return outdto.getForward();
    }

    /**
     * 前処理
     * @customizable
     */
    protected void searchSetup() throws Exception {
        // START UOC

        // END UOC
    }

    /**
     * 前処理
     * @customizable
     */
    protected void checkSetup() throws Exception {
        // START UOC

        // END UOC
    }

    /**
     * 後処理
     * @customizable
     */
    protected String checkNext(BaseDTO outdto) throws Exception {
        // START UOC

        // END UOC
        setNextDTO(outdto);
        return outdto.getForward();
    }

    /**
     * 後処理
     * @customizable
     */
    protected String viewNext(BaseDTO outdto) throws Exception {
        // START UOC
        //担当変更状況テーブルデータが検索された場合
        if (dto.getJkrSosStsTableData() != null) {
            //戻るためのDTOセッション格納キー
            request.getSession().setAttribute(RdmConstantsData.NC001_RETURN_DTO_KEY, dto);
        } else {
            //「リスト作成依頼」押下時に設定されたセッション情報をクリアする
            request.getSession().removeAttribute(RdmConstantsData.NC001_RETURN_DTO_KEY);
        }
        // END UOC
        setNextDTO(outdto);
        return outdto.getForward();
    }

    /**
     * 前処理
     * @customizable
     */
    protected void commonSetup() throws Exception {
        // START UOC

        // END UOC
    }

    /**
     * 後処理
     * @customizable
     */
    protected String commonNext(BaseDTO outdto) throws Exception {
        // START UOC

        // END UOC
        setNextDTO(outdto);
        return outdto.getForward();
    }

    /**
     * 後処理
     * @customizable
     */
    protected String showNext(BaseDTO outdto) throws Exception {
        // START UOC

        // END UOC
        setNextDTO(outdto);
        return outdto.getForward();
    }

}
