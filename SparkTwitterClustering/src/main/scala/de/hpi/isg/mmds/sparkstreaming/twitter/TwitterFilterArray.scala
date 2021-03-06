package de.hpi.isg.mmds.sparkstreaming.twitter

object TwitterFilterArray {

  // reads config files to determine filter string for Twitter API
  def getFilterArray: Array[String] = {

    var stream = getClass.getResourceAsStream("/domains.txt")
    var result = scala.io.Source.fromInputStream(stream).getLines().toArray

    stream = getClass.getResourceAsStream("/keywords.txt")
    result ++= scala.io.Source.fromInputStream(stream).getLines()

    stream = getClass.getResourceAsStream("/newspapers.txt")
    val newspapers = scala.io.Source.fromInputStream(stream).getLines()
    result ++= newspapers.map(newspaper => newspaper.substring(newspaper.indexOf("@") + 1))

    result
  }

}
