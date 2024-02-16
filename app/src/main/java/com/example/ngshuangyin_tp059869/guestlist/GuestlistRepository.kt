package com.example.ngshuangyin_tp059869.guestlist


class GuestlistRepository(private val dao: GuestlistDao) {

    val guestlists = dao.getAllGuestlist()

    suspend fun insert(guestlist: Guestlist): Long {
        return dao.insertGuestlist(guestlist)
    }

    suspend fun update(guestlist: Guestlist): Int{
        return dao.updateGuestlist(guestlist)
    }

    suspend fun delete(guestlist: Guestlist): Int{
        return dao.deleteGuestlist(guestlist)
    }

    suspend fun deleteAllGL(): Int {
        return dao.deleteAllGuestlists()
    }
}