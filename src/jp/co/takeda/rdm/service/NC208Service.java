/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import jp.co.takeda.rdm.common.BaseDTO;
import jp.co.takeda.rdm.common.BaseEntity;
import jp.co.takeda.rdm.common.BaseService;
import jp.co.takeda.rdm.dto.InsTrtDataList;
import jp.co.takeda.rdm.dto.NC208DTO;
import jp.co.takeda.rdm.entity.join.SelectInsTrtListEntity;



/**
 * Serviceクラス（NC208)
 * @generated
 */
@Named
public class NC208Service extends BaseService {

    /**
     * ログインスタンス
     * @generated
     */
    private static Log log = LogFactory.getLog(NC208Service.class);

    /**
     * イベント処理
     * @param dto NC204DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO init(NC208DTO dto) {
        BaseDTO outdto = dto;
        // START UOC

        // ページ数(現在:１ページ目から)
        dto.setPageCntCur(1);

        //検索を行う
        outdto = search(dto);

        // END UOC
        return outdto;
    }

    /**
     * イベント処理
     * @param dto NC208DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO search(NC208DTO dto) {
        BaseDTO outdto = dto;
        // START UOC

        //一覧検索件数取得の検索条件の設定
        SelectInsTrtListEntity paramEntity = new SelectInsTrtListEntity();

        //親画面から受け取った施設固定コードを定義
        paramEntity.setInsNo(dto.getInsNoKakusi());

        List<BaseEntity> selectParam = dao.select(paramEntity);

        //検索結果が0件の場合
        if (CollectionUtils.isEmpty(selectParam)) {
        	return outdto;
        }

         //画面初期表示時の領域別担当者一覧を取得する
        SelectInsTrtListEntity selectCntEntity = (SelectInsTrtListEntity)dao.select(paramEntity).get(0);

        //ページャー情報設定
//       dto.initPageInfo(dto.getPageCntCur(), selectCntEntity.getRecCnt(), 20);

        List<InsTrtDataList> insTrtDataList = new ArrayList<InsTrtDataList>();

        //検索結果はある場合
        if (selectCntEntity.getRecCnt() > 0) {
            //一覧情報の検索条件の設定

            //画面初期表示時の帳票一覧を取得する
            List<SelectInsTrtListEntity> insTrtListEntity = dao.select(paramEntity);

            for (SelectInsTrtListEntity entity : insTrtListEntity) {
            	InsTrtDataList dataRecord = new InsTrtDataList();

                //入力_施設固定コード
                dataRecord.setInsNo(entity.getInsNo());
                //施設略式漢字名
                dataRecord.setInsAbbrName(entity.getInsAbbrName());
                //領域
                dataRecord.setTrtNm(entity.getTrtNm());
                //所属
                if (entity.getBumon() == null) {
                	dataRecord.setBumon("");
                }
                else {
                	dataRecord.setBumon(entity.getBumon());
                }
                //担当者
                dataRecord.setJgiName(entity.getJgiName());
                //メールアドレス
                if (entity.getJgiMailAddress() == null) {
                	dataRecord.setJgiMailAddress("");
                }
                else {
                	dataRecord.setJgiMailAddress(entity.getJgiMailAddress());
                }

                //主副担当区分
                if (entity.getValue1Kanj() == null) {
                	dataRecord.setValue1Kanj("");
                }
                else {
                	dataRecord.setValue1Kanj(entity.getValue1Kanj());
                }

                //リストにデータ追加
                insTrtDataList.add(dataRecord);
            }

            //施設固定CをDTOに入れる
            dto.setInsNo("101108002");

            //施設略式漢字名を取り出す
            InsTrtDataList instrt = insTrtDataList.get(0);
            dto.setInsAbbrName(instrt.getInsAbbrName());
        }
        //検索された帳票一覧をDTOに設定する
        dto.setInsTrtDataList(insTrtDataList);
        // END UOC
        return dto;
    }

    /**
     * イベント処理
     * @param dto NC208DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO page(NC208DTO dto) {
        BaseDTO outdto = dto;
        // START UOC

        //検索を行う
        outdto = search(dto);

        // END UOC
        return outdto;
    }

}
