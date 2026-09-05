package com.nothing.database.old;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.nothing.caseble.NothingCaseParser;
import com.nothing.database.old.entity.Device;
import com.nothing.database.old.entity.OTABreakpointDown;
import com.nothing.database.old.entity.OTABreakpointResume;
import com.nothing.database.old.entity.WidgetsID;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /tmp/source/classes6.dex */
public final class DeviceDao_Impl implements DeviceDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<Device> __deletionAdapterOfDevice;
    private final EntityDeletionOrUpdateAdapter<OTABreakpointDown> __deletionAdapterOfOTABreakpointDown;
    private final EntityInsertionAdapter<Device> __insertionAdapterOfDevice;
    private final EntityInsertionAdapter<OTABreakpointDown> __insertionAdapterOfOTABreakpointDown;
    private final EntityInsertionAdapter<OTABreakpointResume> __insertionAdapterOfOTABreakpointResume;
    private final EntityInsertionAdapter<WidgetsID> __insertionAdapterOfWidgetsID;
    private final SharedSQLiteStatement __preparedStmtOfDelete;
    private final SharedSQLiteStatement __preparedStmtOfDelete_1;
    private final SharedSQLiteStatement __preparedStmtOfUpDateDeviceName;
    private final SharedSQLiteStatement __preparedStmtOfUpdateColorType;
    private final SharedSQLiteStatement __preparedStmtOfUpdateColorType_1;
    private final SharedSQLiteStatement __preparedStmtOfUpdateDeviceVersion;
    private final EntityDeletionOrUpdateAdapter<Device> __updateAdapterOfDevice;

    public DeviceDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfDevice = new EntityInsertionAdapter<Device>(__db) { // from class: com.nothing.database.old.DeviceDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR IGNORE INTO `device` (`name`,`address`,`color_type`,`device_type`,`rank`,`date`,`delete`,`connected`,`deviceVersion`) VALUES (?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, Device device) {
                if (device.getName() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, device.getName());
                }
                if (device.getAddress() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, device.getAddress());
                }
                supportSQLiteStatement.bindLong(3, device.getColorType());
                supportSQLiteStatement.bindLong(4, device.getDeviceType());
                supportSQLiteStatement.bindLong(5, device.getRank());
                supportSQLiteStatement.bindLong(6, device.getDate());
                supportSQLiteStatement.bindLong(7, device.getDelete() ? 1L : 0L);
                supportSQLiteStatement.bindLong(8, device.getConnected() ? 1L : 0L);
                if (device.getDeviceVersion() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, device.getDeviceVersion());
                }
            }
        };
        this.__insertionAdapterOfOTABreakpointResume = new EntityInsertionAdapter<OTABreakpointResume>(__db) { // from class: com.nothing.database.old.DeviceDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `ota_breakpoint_resume` (`address`,`file_md5`,`codes`) VALUES (?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final OTABreakpointResume entity) {
                if (entity.getAddress() == null) {
                    statement.bindNull(1);
                } else {
                    statement.bindString(1, entity.getAddress());
                }
                if (entity.getFileMD5() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getFileMD5());
                }
                if (entity.getCodes() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getCodes());
                }
            }
        };
        this.__insertionAdapterOfOTABreakpointDown = new EntityInsertionAdapter<OTABreakpointDown>(__db) { // from class: com.nothing.database.old.DeviceDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `ota_breakpoint_down` (`address`,`savePath`,`downloadVersion`,`fileSize`,`downloadSize`,`isValid`) VALUES (?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, OTABreakpointDown oTABreakpointDown) {
                if (oTABreakpointDown.getAddress() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, oTABreakpointDown.getAddress());
                }
                if (oTABreakpointDown.getSavePath() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, oTABreakpointDown.getSavePath());
                }
                if (oTABreakpointDown.getDownloadVersion() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, oTABreakpointDown.getDownloadVersion());
                }
                supportSQLiteStatement.bindLong(4, oTABreakpointDown.getFileSize());
                supportSQLiteStatement.bindLong(5, oTABreakpointDown.getDownloadSize());
                supportSQLiteStatement.bindLong(6, oTABreakpointDown.getIsValid() ? 1L : 0L);
            }
        };
        this.__insertionAdapterOfWidgetsID = new EntityInsertionAdapter<WidgetsID>(__db) { // from class: com.nothing.database.old.DeviceDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `widgets_id` (`appWidgetId`,`address`,`deviceColor`,`widgetTheme`) VALUES (?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final WidgetsID entity) {
                statement.bindLong(1, entity.getAppWidgetId());
                if (entity.getAddress() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getAddress());
                }
                statement.bindLong(3, entity.getDeviceColor());
                statement.bindLong(4, entity.getWidgetTheme());
            }
        };
        this.__deletionAdapterOfDevice = new EntityDeletionOrUpdateAdapter<Device>(__db) { // from class: com.nothing.database.old.DeviceDao_Impl.5
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "DELETE FROM `device` WHERE `address` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final Device entity) {
                if (entity.getAddress() == null) {
                    statement.bindNull(1);
                } else {
                    statement.bindString(1, entity.getAddress());
                }
            }
        };
        this.__deletionAdapterOfOTABreakpointDown = new EntityDeletionOrUpdateAdapter<OTABreakpointDown>(__db) { // from class: com.nothing.database.old.DeviceDao_Impl.6
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "DELETE FROM `ota_breakpoint_down` WHERE `address` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final OTABreakpointDown entity) {
                if (entity.getAddress() == null) {
                    statement.bindNull(1);
                } else {
                    statement.bindString(1, entity.getAddress());
                }
            }
        };
        this.__updateAdapterOfDevice = new EntityDeletionOrUpdateAdapter<Device>(__db) { // from class: com.nothing.database.old.DeviceDao_Impl.7
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "UPDATE OR ABORT `device` SET `name` = ?,`address` = ?,`color_type` = ?,`device_type` = ?,`rank` = ?,`date` = ?,`delete` = ?,`connected` = ?,`deviceVersion` = ? WHERE `address` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, Device device) {
                if (device.getName() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, device.getName());
                }
                if (device.getAddress() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, device.getAddress());
                }
                supportSQLiteStatement.bindLong(3, device.getColorType());
                supportSQLiteStatement.bindLong(4, device.getDeviceType());
                supportSQLiteStatement.bindLong(5, device.getRank());
                supportSQLiteStatement.bindLong(6, device.getDate());
                supportSQLiteStatement.bindLong(7, device.getDelete() ? 1L : 0L);
                supportSQLiteStatement.bindLong(8, device.getConnected() ? 1L : 0L);
                if (device.getDeviceVersion() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, device.getDeviceVersion());
                }
                if (device.getAddress() == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, device.getAddress());
                }
            }
        };
        this.__preparedStmtOfDelete = new SharedSQLiteStatement(__db) { // from class: com.nothing.database.old.DeviceDao_Impl.8
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "delete from device where `address` = ?";
            }
        };
        this.__preparedStmtOfDelete_1 = new SharedSQLiteStatement(__db) { // from class: com.nothing.database.old.DeviceDao_Impl.9
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "delete from widgets_id where `appWidgetId` = ?";
            }
        };
        this.__preparedStmtOfUpdateColorType = new SharedSQLiteStatement(__db) { // from class: com.nothing.database.old.DeviceDao_Impl.10
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "update device set color_type = ? where `address` = ?";
            }
        };
        this.__preparedStmtOfUpdateColorType_1 = new SharedSQLiteStatement(__db) { // from class: com.nothing.database.old.DeviceDao_Impl.11
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "update widgets_id set deviceColor = ? where `appWidgetId` = ?";
            }
        };
        this.__preparedStmtOfUpDateDeviceName = new SharedSQLiteStatement(__db) { // from class: com.nothing.database.old.DeviceDao_Impl.12
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "update device set name = ? where `address` = ?";
            }
        };
        this.__preparedStmtOfUpdateDeviceVersion = new SharedSQLiteStatement(__db) { // from class: com.nothing.database.old.DeviceDao_Impl.13
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "update device set deviceVersion = ? where `address` = ?";
            }
        };
    }

    @Override // com.nothing.database.old.DeviceDao
    public void insert(final Device device) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfDevice.insert(device);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.nothing.database.old.DeviceDao
    public void insert(final List<Device> devices) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfDevice.insert(devices);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.nothing.database.old.DeviceDao
    public void insert(final OTABreakpointResume item) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfOTABreakpointResume.insert(item);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.nothing.database.old.DeviceDao
    public void insert(final OTABreakpointDown item) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfOTABreakpointDown.insert(item);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.nothing.database.old.DeviceDao
    public void insert(final WidgetsID item) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfWidgetsID.insert(item);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.nothing.database.old.DeviceDao
    public void delete(final Device device) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfDevice.handle(device);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.nothing.database.old.DeviceDao
    public void delete(final List<Device> devices) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfDevice.handleMultiple(devices);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.nothing.database.old.DeviceDao
    public void delete(final OTABreakpointDown breakPointDown) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfOTABreakpointDown.handle(breakPointDown);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.nothing.database.old.DeviceDao
    public void update(final Device... device) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfDevice.handleMultiple(device);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.nothing.database.old.DeviceDao
    public void update(final List<Device> device) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfDevice.handleMultiple(device);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.nothing.database.old.DeviceDao
    public void delete(final String address) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDelete.acquire();
        if (address == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, address);
        }
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
                this.__db.endTransaction();
                this.__preparedStmtOfDelete.release(supportSQLiteStatementAcquire);
            } catch (Throwable th) {
                this.__db.endTransaction();
                throw th;
            }
        } catch (Throwable th2) {
            this.__preparedStmtOfDelete.release(supportSQLiteStatementAcquire);
            throw th2;
        }
    }

    @Override // com.nothing.database.old.DeviceDao
    public void delete(final int appWidgetId) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDelete_1.acquire();
        supportSQLiteStatementAcquire.bindLong(1, appWidgetId);
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
                this.__db.endTransaction();
                this.__preparedStmtOfDelete_1.release(supportSQLiteStatementAcquire);
            } catch (Throwable th) {
                this.__db.endTransaction();
                throw th;
            }
        } catch (Throwable th2) {
            this.__preparedStmtOfDelete_1.release(supportSQLiteStatementAcquire);
            throw th2;
        }
    }

    @Override // com.nothing.database.old.DeviceDao
    public void updateColorType(final String address, final int colorType) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdateColorType.acquire();
        supportSQLiteStatementAcquire.bindLong(1, colorType);
        if (address == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, address);
        }
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
                this.__db.endTransaction();
                this.__preparedStmtOfUpdateColorType.release(supportSQLiteStatementAcquire);
            } catch (Throwable th) {
                this.__db.endTransaction();
                throw th;
            }
        } catch (Throwable th2) {
            this.__preparedStmtOfUpdateColorType.release(supportSQLiteStatementAcquire);
            throw th2;
        }
    }

    @Override // com.nothing.database.old.DeviceDao
    public void updateColorType(final int widgetId, final int colorType) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdateColorType_1.acquire();
        supportSQLiteStatementAcquire.bindLong(1, colorType);
        supportSQLiteStatementAcquire.bindLong(2, widgetId);
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
                this.__db.endTransaction();
                this.__preparedStmtOfUpdateColorType_1.release(supportSQLiteStatementAcquire);
            } catch (Throwable th) {
                this.__db.endTransaction();
                throw th;
            }
        } catch (Throwable th2) {
            this.__preparedStmtOfUpdateColorType_1.release(supportSQLiteStatementAcquire);
            throw th2;
        }
    }

    @Override // com.nothing.database.old.DeviceDao
    public void upDateDeviceName(final String address, final String deviceName) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpDateDeviceName.acquire();
        if (deviceName == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, deviceName);
        }
        if (address == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, address);
        }
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
                this.__db.endTransaction();
                this.__preparedStmtOfUpDateDeviceName.release(supportSQLiteStatementAcquire);
            } catch (Throwable th) {
                this.__db.endTransaction();
                throw th;
            }
        } catch (Throwable th2) {
            this.__preparedStmtOfUpDateDeviceName.release(supportSQLiteStatementAcquire);
            throw th2;
        }
    }

    @Override // com.nothing.database.old.DeviceDao
    public void updateDeviceVersion(final String address, final String deviceVersion) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdateDeviceVersion.acquire();
        if (deviceVersion == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, deviceVersion);
        }
        if (address == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, address);
        }
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
                this.__db.endTransaction();
                this.__preparedStmtOfUpdateDeviceVersion.release(supportSQLiteStatementAcquire);
            } catch (Throwable th) {
                this.__db.endTransaction();
                throw th;
            }
        } catch (Throwable th2) {
            this.__preparedStmtOfUpdateDeviceVersion.release(supportSQLiteStatementAcquire);
            throw th2;
        }
    }

    @Override // com.nothing.database.old.DeviceDao
    public List<Device> getAll() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from device", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "address");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "color_type");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, NothingCaseParser.KEY_DEVICE_TYPE);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rank");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "delete");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "connected");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "deviceVersion");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new Device(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getInt(columnIndexOrThrow3), cursorQuery.getInt(columnIndexOrThrow4), cursorQuery.getInt(columnIndexOrThrow5), cursorQuery.getLong(columnIndexOrThrow6), cursorQuery.getInt(columnIndexOrThrow7) != 0, cursorQuery.getInt(columnIndexOrThrow8) != 0, cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9)));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.nothing.database.old.DeviceDao
    public List<WidgetsID> getAllWidget() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from widgets_id", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "appWidgetId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "address");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "deviceColor");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "widgetTheme");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new WidgetsID(cursorQuery.getInt(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getInt(columnIndexOrThrow3), cursorQuery.getInt(columnIndexOrThrow4)));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.nothing.database.old.DeviceDao
    public int count() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select count(*) from device", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.nothing.database.old.DeviceDao
    public LiveData<List<Device>> getAvailableDevices() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from device order by rank", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"device"}, false, new Callable<List<Device>>() { // from class: com.nothing.database.old.DeviceDao_Impl.14
            @Override // java.util.concurrent.Callable
            public List<Device> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(DeviceDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "address");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "color_type");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, NothingCaseParser.KEY_DEVICE_TYPE);
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rank");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "delete");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "connected");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "deviceVersion");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(new Device(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getInt(columnIndexOrThrow3), cursorQuery.getInt(columnIndexOrThrow4), cursorQuery.getInt(columnIndexOrThrow5), cursorQuery.getLong(columnIndexOrThrow6), cursorQuery.getInt(columnIndexOrThrow7) != 0, cursorQuery.getInt(columnIndexOrThrow8) != 0, cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9)));
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }

            protected void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.nothing.database.old.DeviceDao
    public int getAvailableCount() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select count(*) from device", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.nothing.database.old.DeviceDao
    public List<Device> getSelectDevice(final String address) {
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
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "color_type");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, NothingCaseParser.KEY_DEVICE_TYPE);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rank");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "delete");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "connected");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "deviceVersion");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new Device(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getInt(columnIndexOrThrow3), cursorQuery.getInt(columnIndexOrThrow4), cursorQuery.getInt(columnIndexOrThrow5), cursorQuery.getLong(columnIndexOrThrow6), cursorQuery.getInt(columnIndexOrThrow7) != 0, cursorQuery.getInt(columnIndexOrThrow8) != 0, cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9)));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.nothing.database.old.DeviceDao
    public List<OTABreakpointResume> getBreakpointResume(final String address) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from ota_breakpoint_resume where `address` = ? ", 1);
        if (address == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, address);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "address");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "file_md5");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "codes");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new OTABreakpointResume(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3)));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.nothing.database.old.DeviceDao
    public List<OTABreakpointDown> getBreakpointDown(final String address) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from ota_breakpoint_down where `address` = ? ", 1);
        if (address == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, address);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "address");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "savePath");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "downloadVersion");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fileSize");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "downloadSize");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isValid");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new OTABreakpointDown(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getLong(columnIndexOrThrow4), cursorQuery.getLong(columnIndexOrThrow5), cursorQuery.getInt(columnIndexOrThrow6) != 0));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.nothing.database.old.DeviceDao
    public List<WidgetsID> getWidgetsID(final int appWidgetId) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from widgets_id where `appWidgetId` = ? ", 1);
        roomSQLiteQueryAcquire.bindLong(1, appWidgetId);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "appWidgetId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "address");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "deviceColor");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "widgetTheme");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new WidgetsID(cursorQuery.getInt(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getInt(columnIndexOrThrow3), cursorQuery.getInt(columnIndexOrThrow4)));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.nothing.database.old.DeviceDao
    public List<WidgetsID> getWidgetsID(final String address) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from widgets_id where `address` = ? ", 1);
        if (address == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, address);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "appWidgetId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "address");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "deviceColor");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "widgetTheme");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new WidgetsID(cursorQuery.getInt(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getInt(columnIndexOrThrow3), cursorQuery.getInt(columnIndexOrThrow4)));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.nothing.database.old.DeviceDao
    public List<Device> getDevice(final String address) {
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
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "color_type");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, NothingCaseParser.KEY_DEVICE_TYPE);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rank");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "delete");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "connected");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "deviceVersion");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new Device(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getInt(columnIndexOrThrow3), cursorQuery.getInt(columnIndexOrThrow4), cursorQuery.getInt(columnIndexOrThrow5), cursorQuery.getLong(columnIndexOrThrow6), cursorQuery.getInt(columnIndexOrThrow7) != 0, cursorQuery.getInt(columnIndexOrThrow8) != 0, cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9)));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.nothing.database.old.DeviceDao
    public List<WidgetsID> getAllWidgets() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from widgets_id", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "appWidgetId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "address");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "deviceColor");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "widgetTheme");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new WidgetsID(cursorQuery.getInt(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getInt(columnIndexOrThrow3), cursorQuery.getInt(columnIndexOrThrow4)));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.nothing.database.old.DeviceDao
    public Cursor getCursorAllWidget() {
        return this.__db.query(RoomSQLiteQuery.acquire("select * from widgets_id", 0));
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
