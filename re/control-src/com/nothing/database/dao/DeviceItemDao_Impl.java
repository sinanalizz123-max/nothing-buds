package com.nothing.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.nothing.database.entity.DeviceItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /tmp/source/classes6.dex */
public final class DeviceItemDao_Impl implements DeviceItemDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<DeviceItem> __deletionAdapterOfDeviceItem;
    private final EntityInsertionAdapter<DeviceItem> __insertionAdapterOfDeviceItem;
    private final EntityDeletionOrUpdateAdapter<DeviceItem> __updateAdapterOfDeviceItem;

    public DeviceItemDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfDeviceItem = new EntityInsertionAdapter<DeviceItem>(__db) { // from class: com.nothing.database.dao.DeviceItemDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR IGNORE INTO `device` (`name`,`address`,`connected`,`deviceVersion`,`modelId`,`sn`,`tipsShow`,`guideShow`,`homeTips`,`otaTips`,`smartDialTips`,`otaTipsTime`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, DeviceItem deviceItem) {
                if (deviceItem.getName() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, deviceItem.getName());
                }
                if (deviceItem.getAddress() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, deviceItem.getAddress());
                }
                supportSQLiteStatement.bindLong(3, deviceItem.getConnected() ? 1L : 0L);
                if (deviceItem.getDeviceVersion() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, deviceItem.getDeviceVersion());
                }
                if (deviceItem.getModelId() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, deviceItem.getModelId());
                }
                if (deviceItem.getSn() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, deviceItem.getSn());
                }
                supportSQLiteStatement.bindLong(7, deviceItem.getTipsShow() ? 1L : 0L);
                supportSQLiteStatement.bindLong(8, deviceItem.getGuideShow() ? 1L : 0L);
                supportSQLiteStatement.bindLong(9, deviceItem.getHomeTips() ? 1L : 0L);
                if (deviceItem.getOtaTips() == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, deviceItem.getOtaTips());
                }
                supportSQLiteStatement.bindLong(11, deviceItem.getSmartDialTips() ? 1L : 0L);
                supportSQLiteStatement.bindLong(12, deviceItem.getOtaTipsTime());
            }
        };
        this.__deletionAdapterOfDeviceItem = new EntityDeletionOrUpdateAdapter<DeviceItem>(__db) { // from class: com.nothing.database.dao.DeviceItemDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "DELETE FROM `device` WHERE `address` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final DeviceItem entity) {
                if (entity.getAddress() == null) {
                    statement.bindNull(1);
                } else {
                    statement.bindString(1, entity.getAddress());
                }
            }
        };
        this.__updateAdapterOfDeviceItem = new EntityDeletionOrUpdateAdapter<DeviceItem>(__db) { // from class: com.nothing.database.dao.DeviceItemDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "UPDATE OR ABORT `device` SET `name` = ?,`address` = ?,`connected` = ?,`deviceVersion` = ?,`modelId` = ?,`sn` = ?,`tipsShow` = ?,`guideShow` = ?,`homeTips` = ?,`otaTips` = ?,`smartDialTips` = ?,`otaTipsTime` = ? WHERE `address` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, DeviceItem deviceItem) {
                if (deviceItem.getName() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, deviceItem.getName());
                }
                if (deviceItem.getAddress() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, deviceItem.getAddress());
                }
                supportSQLiteStatement.bindLong(3, deviceItem.getConnected() ? 1L : 0L);
                if (deviceItem.getDeviceVersion() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, deviceItem.getDeviceVersion());
                }
                if (deviceItem.getModelId() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, deviceItem.getModelId());
                }
                if (deviceItem.getSn() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, deviceItem.getSn());
                }
                supportSQLiteStatement.bindLong(7, deviceItem.getTipsShow() ? 1L : 0L);
                supportSQLiteStatement.bindLong(8, deviceItem.getGuideShow() ? 1L : 0L);
                supportSQLiteStatement.bindLong(9, deviceItem.getHomeTips() ? 1L : 0L);
                if (deviceItem.getOtaTips() == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, deviceItem.getOtaTips());
                }
                supportSQLiteStatement.bindLong(11, deviceItem.getSmartDialTips() ? 1L : 0L);
                supportSQLiteStatement.bindLong(12, deviceItem.getOtaTipsTime());
                if (deviceItem.getAddress() == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindString(13, deviceItem.getAddress());
                }
            }
        };
    }

    @Override // com.nothing.database.dao.DeviceItemDao
    public void insertDeviceItem(final DeviceItem... deviceItem) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfDeviceItem.insert(deviceItem);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.nothing.database.dao.DeviceItemDao
    public void deleteDeviceItem(final DeviceItem... deviceItem) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfDeviceItem.handleMultiple(deviceItem);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.nothing.database.dao.DeviceItemDao
    public void updateDeviceItem(final DeviceItem... deviceItem) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfDeviceItem.handleMultiple(deviceItem);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.nothing.database.dao.DeviceItemDao
    public List<DeviceItem> getAllDeviceItem() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from device", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "address");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "connected");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "deviceVersion");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "modelId");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sn");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tipsShow");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "guideShow");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "homeTips");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "otaTips");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "smartDialTips");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "otaTipsTime");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new DeviceItem(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getInt(columnIndexOrThrow3) != 0, cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5), cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6), cursorQuery.getInt(columnIndexOrThrow7) != 0, cursorQuery.getInt(columnIndexOrThrow8) != 0, cursorQuery.getInt(columnIndexOrThrow9) != 0, cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10), cursorQuery.getInt(columnIndexOrThrow11) != 0, cursorQuery.getLong(columnIndexOrThrow12)));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.nothing.database.dao.DeviceItemDao
    public List<DeviceItem> getDeviceItem(final String address) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from device where `address` = ?", 1);
        if (address == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, address);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "address");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "connected");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "deviceVersion");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "modelId");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sn");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tipsShow");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "guideShow");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "homeTips");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "otaTips");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "smartDialTips");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "otaTipsTime");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new DeviceItem(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getInt(columnIndexOrThrow3) != 0, cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5), cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6), cursorQuery.getInt(columnIndexOrThrow7) != 0, cursorQuery.getInt(columnIndexOrThrow8) != 0, cursorQuery.getInt(columnIndexOrThrow9) != 0, cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10), cursorQuery.getInt(columnIndexOrThrow11) != 0, cursorQuery.getLong(columnIndexOrThrow12)));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
