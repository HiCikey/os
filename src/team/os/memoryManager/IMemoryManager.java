package team.os.memoryManager;

import java.util.List;

public interface IMemoryManager {
    /**
     * 判断是否有足够大的内存分区
     *
     * @param pSize 进程需要的内存大小
     * @return 内存足够分配返回true 否则返回false
     */
    boolean memoryRequest(int pSize);

    /**
     * 为进程分配足够大的内存空间
     *
     * @param pid     进程id
     * @param proSize 进程所需的内存大小
     */
    void memoryAllocate(int pid, int proSize);

    /**
     * 释放中断、终止的进程内存
     *
     * @param pid 进程id
     */
    void memoryFree(int pid);

    /**
     * 为进程声明的变量分配内存
     *
     * @param pid     变量所属进程id
     * @param varType 变量类型
     * @param size    变量需要的内存大小
     * @return 区分不同变量的唯一标识，返回-1时为异常情况
     */
    int varDeclare(int pid, String varType, int size);

    /**
     * 返回int变量的值
     *
     * @param varID 变量标识
     */
    int varReadInt(int varID);

    /**
     * 返回String变量的值
     *
     * @param varID 变量标识
     */
    String varReadString(int varID);

    /**
     * 更改int变量的值
     *
     * @param varValue 写的值
     * @param varID    变量标识
     */
    void varWriteInt(int varID, int varValue);

    /**
     * 更改String变量的值
     *
     * @param varValue 写的值
     * @param varID    变量标识
     */
    void varWriteString(int varID, String varValue);

    /**
     * 返回内存分配情况
     */
    List<Partition> getMemoryAllocation();
}
