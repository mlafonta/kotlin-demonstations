package com.controllerTests

import com.stubs.GuestServiceStub
import com.controller.GuestController
import com.dto.Guest
import com.dto.Reservation
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Test

@MicronautTest
internal class GuestControllerTest() {

    private val guestController: GuestController = GuestController(
        guestService = GuestServiceStub()
    )

    @Test
    fun testGetGuestById() {
        val expectedValue = Guest(
            id = 1,
            firstName = "Test First Name 1",
            lastName = "Test Last Name 1",
            reservation = Reservation(
                roomNumber = 1,
                startTimestamp = 1,
                endTimestamp = 2
            )
        )
        val actualValue = guestController.getGuestById(1)
        assert(expectedValue ==  actualValue)
    }

    @Test
    fun testGetAllGuests() {
        val expectedValue = arrayListOf(
            Guest(
                id = 1,
                firstName = "Test First Name 1",
                lastName = "Test Last Name 1",
                reservation = Reservation(
                    roomNumber = 1,
                    startTimestamp = 1,
                    endTimestamp = 2
                )
            ),
            Guest(
                id = 2,
                firstName = "Test First Name 2",
                lastName = "Test Last Name 2",
                reservation = Reservation(
                    roomNumber = 2,
                    startTimestamp = 1,
                    endTimestamp = 2
                )
            )
        )

        val actualValue = guestController.getAllGuests()
        assert(expectedValue == actualValue)
    }
}
