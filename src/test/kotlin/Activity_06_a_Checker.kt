import activity.`06`.*
import activity.`07`.Activity_07_a
import discussion.errors.CellNumberException
import org.junit.jupiter.api.Assertions

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.util.*

internal class Activity_06_a_Checker {

    private lateinit var a6a: Activity_06_a;

    @Test //Annotation
    fun checkGrade() {
        a6a = Activity_06_a()
        val a7a: Activity_07_a = Activity_07_a(a6a)

        Assertions.assertEquals(0.0, a7a.checkGrade(94.0))
        Assertions.assertEquals(0.0, a7a.checkGrade(94.0))
        Assertions.assertEquals(0.0, a7a.checkGrade(94.0))

    }

    @Test
    fun checkArray() {
        a6a = Activity_06_a()
        a6a.arrPerson.add(activity.`06`.Person("EBRAHIM", "ESCABARTE", "DIANGCA", Date(1992, 7, 22)))
        a6a.arrPerson.add(activity.`06`.Person("ROSE MAIRIE", "GARCIA", "RECENTES", Date(1992, 7, 16)))
        a6a.arrPerson.add(activity.`06`.Person("RAFI", "RECENTES", "DIANGCA", Date(2020, 2, 27)))
        a6a.arrPerson.add(activity.`06`.Person("FARHANA", "RECENTES", "DIANGCA", Date(2021, 8, 13)))
        a6a.arrPerson.add(activity.`06`.Person("EBRAHIM", "ESCABARTE", "DIANGCA", Date(1992, 7, 22)))
        a6a.arrPerson.add(activity.`06`.Person("ROSE MAIRIE", "GARCIA", "RECENTES", Date(1992, 7, 16)))
        a6a.arrPerson.add(activity.`06`.Person("RAFI", "RECENTES", "DIANGCA", Date(2020, 2, 27)))
        a6a.arrPerson.add(activity.`06`.Person("FARHANA", "RECENTES", "DIANGCA", Date(2021, 8, 13)))
        a6a.arrPerson.add(activity.`06`.Person("EBRAHIM", "ESCABARTE", "DIANGCA", Date(1992, 7, 22)))
        a6a.arrPerson.add(activity.`06`.Person("ROSE MAIRIE", "GARCIA", "RECENTES", Date(1992, 7, 16)))
        a6a.arrPerson.add(activity.`06`.Person("RAFI", "RECENTES", "DIANGCA", Date(2020, 2, 27)))
        a6a.arrPerson.add(activity.`06`.Person("FARHANA", "RECENTES", "DIANGCA", Date(2021, 8, 13)))

        assertThrows<StudentArrayException.ArrayExemption.LimitArrayExemption> {
            a6a.checkStudentGrades(a6a.arrPerson)
        }

        a6a = Activity_06_a()

        assertThrows<StudentArrayException.ArrayExemption.EmptyArrayExemption> {
            a6a.checkStudentGrades(a6a.arrPerson)
        }

    }

}