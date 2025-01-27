/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2014, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.jkr.common;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

/**
 * DAOクラス
 * @generated
 */
@Named
public class DAO extends SqlSessionDaoSupportEx {

    /**
     * バッチ用sqlSession
     * @generated
     */
    @Inject
    private SqlSession batchSqlSession;

    /**
     * 1件検索(主キー指定)
     * @param entity パラメータ
     * @return エンティティ
     * @generated
     */
    public <Entity extends BaseEntity> Entity selectByPK(Entity entity) {
        return getSqlSession().selectOne(entity.getTableName() + ".selectByPK", entity);
    }

    /**
     * 更新用1件検索(主キー指定)
     * @param entity パラメータ
     * @return エンティティ
     * @generated
     */
    public <Entity extends BaseEntity> Entity selectForUpdate(Entity entity) {
        return getSqlSession().selectOne(entity.getTableName() + ".selectForUpdate", entity);
    }

    /**
     * 全件検索
     * @param entity パラメータ
     * @return エンティティリスト
     * @generated
     */
    public <Entity extends BaseEntity> List<Entity> selectList(Entity entity) {
        return getSqlSession().selectList(entity.getTableName() + ".selectList", entity);
    }

    /**
     * 値が設定された属性を条件として検索
     * @param entity パラメータ
     * @return エンティティリスト
     * @generated
     */
    public <Entity extends BaseEntity> List<Entity> selectByValue(Entity entity) {
        return getSqlSession().selectList(entity.getTableName() + ".selectByValue", entity);
    }

    /**
     * 値が設定された属性を条件としてカウント
     * @param entity パラメータ
     * @return カウント値
     * @generated
     */
    public <Entity extends BaseEntity> int countByValue(Entity entity) {
        return (Integer)getSqlSession().selectOne(entity.getTableName() + ".countByValue", entity);
    }

    /**
     * 1件挿入(主キー指定)。<br/>
     * null値では登録できません。例外が返ります。
     * null値が含まれるEntityで登録する場合、insertByValueメソッドを利用してください。
     * @param paramEntity パラメータ
     * @return 挿入件数
     * @generated
     */
    public <Entity extends BaseEntity> int insertByPK(Entity entity) {
        return getSqlSession().insert(entity.getTableName() + ".insertByPK", entity);
    }

    /**
     * 値が設定された属性のみ挿入(主キー指定)。<br/>
     * null値が含まれるEntityで登録する場合、本メソッドを利用してください（insert文からnull値を除外して実行します）。
     * @param entity パラメータ
     * @return 挿入件数
     * @generated
     */
    public <Entity extends BaseEntity> int insertByValue(Entity entity) {
        return getSqlSession().insert(entity.getTableName() + ".insertByValue", entity);
    }

    /**
     * 1件更新(主キー指定)。<br/>
     * null値が含まれるEntityで更新する場合（null値で更新したい場合）、本メソッドを利用してください。
     * @param entity パラメータ
     * @return 更新件数
     * @generated
     */
    public <Entity extends BaseEntity> int updateByPK(Entity entity) {
        return updateByPK(entity, entity);
    }

    /**
     * 1件更新(主キー指定)。<br/>
     * null値が含まれるEntityで更新する場合（null値で更新したい場合）、本メソッドを利用してください。
     * @param updateEntity set句パラメータ
     * @param searchEntity where句パラメータ
     * @return 更新件数
     * @generated
     */
    public <Entity extends BaseEntity> int updateByPK(Entity updateEntity, Entity searchEntity) {
        Map<String, Entity> parameter = new HashMap<String, Entity>();
        parameter.put("update", updateEntity);
        parameter.put("search", searchEntity);
        return getSqlSession().update(updateEntity.getTableName() + ".updateByPK", parameter);
    }

    /**
     * 値が設定された属性のみ更新(主キー指定)。<br/>
     * null値以外で更新したい場合、本メソッドを利用してください(null値で更新したい項目は、項目のNullFlagをtrueにしてください)。
     * @param entity パラメータ
     * @return 更新件数
     * @generated
     */
    public <Entity extends BaseEntity> int updateByValue(Entity entity) {
        return updateByValue(entity, entity);
    }

    /**
     * 値が設定された属性のみ更新(主キー指定)。<br/>
     * null値以外で更新したい場合、本メソッドを利用してください(null値で更新したい項目は、項目のNullFlagをtrueにしてください)。
     * @param updateEntity set句パラメータ
     * @param searchEntity where句パラメータ
     * @return 更新件数
     * @generated
     */
    public <Entity extends BaseEntity> int updateByValue(Entity updateEntity, Entity searchEntity) {
        Map<String, Entity> parameter = new HashMap<String, Entity>();
        parameter.put("update", updateEntity);
        parameter.put("search", searchEntity);
        return getSqlSession().update(updateEntity.getTableName() + ".updateByValue", parameter);
    }

    /**
     * 1件削除(主キー指定)
     * @param entity パラメータ
     * @return 削除件数
     * @generated
     */
    public <Entity extends BaseEntity> int deleteByPK(Entity entity) {
        return getSqlSession().update(entity.getTableName() + ".deleteByPK", entity);
    }

    /**
     * 値が設定された属性を条件として削除
     * @param entity パラメータ
     * @return 削除件数
     * @generated
     */
    public <Entity extends BaseEntity> int deleteByValue(Entity entity) {
        return getSqlSession().update(entity.getTableName() + ".deleteByValue", entity);
    }

    /**
     * 複数件検索
     * @param paramEntity エンティティ
     * @return エンティティリスト
     * @generated
     */
    public <Entity extends BaseEntity, ParamEntity extends BaseEntity> List<Entity> select(ParamEntity paramEntity) {
        return getSqlSession().selectList(paramEntity.getTableName() + "." + paramEntity.getSqlId(), paramEntity);
    }

    /**
     * 複数件検索
     * @param paramEntity エンティティ
     * @param offset 開始位置
     * @param limit 取得件数
     * @return エンティティリスト
     * @generated
     */
    public <Entity extends BaseEntity, ParamEntity extends BaseEntity> List<Entity> select(ParamEntity paramEntity, int offset, int limit) {
        return getSqlSession().selectList(paramEntity.getTableName() + "." + paramEntity.getSqlId(), paramEntity, new RowBounds(offset, limit));
    }

    /**
     * 任意のINSERT文発行
     * @param paramEntity エンティティ
     * @return 挿入件数
     * @generated
     */
    public <Entity extends BaseEntity, ParamEntity extends BaseEntity> int insert(ParamEntity paramEntity) {
        return getSqlSession().insert(paramEntity.getTableName() + "." + paramEntity.getSqlId(), paramEntity);
    }

    /**
     * 任意のUPDATE文発行
     * @param sqlId SQLID
     * @param paramMap パラメータ
     * @return 更新件数
     * @generated
     */
    public <Entity extends BaseEntity, ParamEntity extends BaseEntity> int update(ParamEntity paramEntity) {
        return getSqlSession().update(paramEntity.getTableName() + "." + paramEntity.getSqlId(), paramEntity);
    }

    /**
     * 任意のDELETE文発行
     * @param sqlId SQLID
     * @param paramMap パラメータ
     * @return 削除件数
     * @generated
     */
    public <Entity extends BaseEntity, ParamEntity extends BaseEntity> int delete(ParamEntity paramEntity) {
        return getSqlSession().delete(paramEntity.getTableName() + "." + paramEntity.getSqlId(), paramEntity);
    }

    /**
     * RowHandler利用
     * @param paramEntity パラメータ
     * @param handler ResultHandler
     * @generated
     */
    public <ParamEntity extends BaseEntity> void selectHandler(ParamEntity paramEntity, ResultHandler handler) {
        getSqlSession().select(paramEntity.getTableName() + "." + paramEntity.getSqlId(), paramEntity, handler);
    }

    /**
     * 任意のINSERT文を発行するバッチ<br/>
     * 本処理はBATCH指定時に有効。但し、通常時とBATCH指定時を同一トランザクションに含めることはできないので注意すること。
     * @param paramEntityList パラメータリスト
     * @return 挿入件数
     * @generated
     */
    public <Entity extends BaseEntity> int insertBatch(List<Entity> entityList) {
        for (Entity entity : entityList) {
            batchSqlSession.insert(entity.getTableName() + ".insertByPK", entity);
        }
        return entityList.size();
    }

    /**
     * 任意のUPDATE文を発行するバッチ<br/>
     * 本処理はBATCH指定時に有効。但し、通常時とBATCH指定時を同一トランザクションに含めることはできないので注意すること。
     * @param entity paramEntityList パラメータリスト
     * @return 更新件数
     * @generated
     */
    public <Entity extends BaseEntity> int updateBatch(List<Entity> entityList ) {
        for (Entity entity : entityList) {
            Map<String, Entity> parameter = new HashMap<String, Entity>();
            parameter.put("update", entity);
            parameter.put("search", entity);
            batchSqlSession.update(entity.getTableName() + ".updateByPK", parameter);
        }
        return entityList.size();
    }

    /**
     * 任意のDELETE文を発行するバッチ<br/>
     * 本処理はBATCH指定時に有効。但し、通常時とBATCH指定時を同一トランザクションに含めることはできないので注意すること。
     * @param entity paramEntityList パラメータリスト
     * @return 削除件数
     * @generated
     */
    public <Entity extends BaseEntity> int deleteBatch(List<Entity> entityList) {
        for (Entity entity : entityList) {
            batchSqlSession.delete(entity.getTableName() + ".deleteByPK", entity);
        }
        return entityList.size();
    }

    /**
     * SQL ストアドプロシージャーを実行するのに使用されるインタフェース取得
     * @param sql SQL ストアドプロシージャー
     * @return CallableStatement
     * @throws SQLException
     * @generated
     */
    public  CallableStatement getPrepareCall(String sql) throws SQLException {
        return getSqlSession().getConnection().prepareCall(sql);
    }
}
