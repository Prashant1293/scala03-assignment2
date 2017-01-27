/**
  * 1.	Complete  Extractor definition  for URL parsing.
  * object URL{
  * *
  * def apply(protocal:String,domain:String,path:String, params:Map[String,String]):String = { / definition
  *}
  * def unapply(url: String): Option[(String, String, String, Map[String, String])] = { / definition
  * }
  *}
  * Description:
  * val url = “ https :// aws.amazon.com / console / home ? state = hash & isauthcode = true & code = 112 ”
  * Extract following fields:
  * protocal = ” https ”
  * domain = “ aws.amazon.com ”
  * path = ” / console / home ”
  * params = Map( “ state ” -> “ hash ”, “ isauthcode ” -> “ true ”, “ code ” -> 112)
  * */

object urlParser extends App{

  val url=urlParser("https","google.com","/home/desktop","state=hash&isauthcode=true&code=112")
  println(url)			//pass the complete url in parts.  

  def apply(prtocolPassed: String, domainName: String, pathName: String, paramsPassed: String): String = {
      prtocolPassed + "://" + domainName + pathName + "?" + paramsPassed
       }			//make the url 

  def unapply(url:String): Option[(String , String, String,Map[String,String])] ={
    val protocolUsed= url.split("://").head
    val urlLeft=url.split("://").tail
    val domainUsed=urlLeft(0).split("/").head
    val pathLeft=urlLeft(0).split("/").tail
    var combine=""
    for(len<- pathLeft.indices )
      combine =combine+"/"+pathLeft(len)

    val pathUsed=combine.split('?').head
    val params=combine.split('?').tail
    val paramArray= params(0).split('&')
    var paramsUsed:Map[String,String]=Map()
    for(i<- paramArray.indices){
      val res=paramArray(i).split('=')
      paramsUsed =Map(res(0) -> res(1)) ++ paramsUsed
    }
    Some(protocolUsed,domainUsed,pathUsed,paramsUsed)
  }
    val result=urlParser.unapply(url)
    println(result)
}				// generate the parts of url
