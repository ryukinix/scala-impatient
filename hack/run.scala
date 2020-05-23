#!/bin/sh
exec scala -nc "$0" "$@"
!#

import scala.sys.process.Process
import java.io.File

object Runner extends App {
  // define if will runs with cat or scala -nc
  def chapterExercises(chapterDir: String): List[File] = {
    val f = new File(chapterDir)
    if (f.exists) {
      f match {
        case f if f.isDirectory => f.listFiles.filter(_.isFile).toList
        case f if f.isFile => List(f)
      }
    } else {
      List[File]()
    }
  }

  def printGreen(string: String) = {
    println(Console.GREEN + string + Console.RESET)
  }

  def exerciseBegin(exName: String) = {
    printGreen(f"[begin] ====================: $exName ===================\n\n")
  }

  def exerciseEnd() = {
    printGreen("\n[end] =================================================\n\n")
  }

  def tabLines(output: String) = {
    for (l <- output.split('\n')) {
      println("\t" + l)
    }
  }

  def scalaCommand(file: File) = {
    exerciseBegin(file.getName)
    tabLines(Process(Seq("cat", file.getAbsolutePath)).!!)
    println("\t> Result:")
    tabLines(Process(Seq("scala", "-nc", file.getAbsolutePath)).!!)
    exerciseEnd()
  }

  def txtCommand(file: File) = {
    exerciseBegin(file.getName)
    tabLines(Process(Seq("cat", file.getAbsolutePath)).!!)
    exerciseEnd()
  }

  def solveExercise(file: File) = {
    file.getName.split('.') match {
      case Array(name, "txt") => txtCommand(file)
      case Array(name, "scala") => scalaCommand(file)
      case _ => None
    }
  }

  args.toList
    .flatMap(chapterExercises)
    .sortBy(f => f.getAbsolutePath)
    .map(solveExercise)
}
