package com.example.ngshuangyin_tp059869.checklist


class ChecklistRepository(private val dao: ChecklistDao) {

    val checklists = dao.getAllChecklist()

    suspend fun insert(checklist: Checklist): Long {
        return dao.insertChecklist(checklist)
    }

    suspend fun update(checklist: Checklist): Int{
        return dao.updateChecklist(checklist)
    }

    suspend fun delete(checklist: Checklist): Int{
        return dao.deleteChecklist(checklist)
    }

    suspend fun deleteAllCL(): Int {
        return dao.deleteAllChecklists()
    }
}

