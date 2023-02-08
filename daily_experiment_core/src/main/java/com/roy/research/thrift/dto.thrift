namespace java com.roy.miscellaneous.thrift.custdto
const string VERSION = "1.0.1"



/**为ThriftResult添加数据不完全和内部错误两种类型
*/

/****************************************************************************************************
* 定义返回值，
* 枚举类型ThriftResult，表示返回结果，成功或失败，如果失败，还可以表示失败原因
* 每种返回类型都对应一个封装的结构体，该结构体其命名遵循规则："Result" + "具体操作结果类型"，结构体都包含两部分内容：
* 第一部分为枚举类型ThriftResult变量result，表示操作结果,可以 表示成功，或失败，失败时可以给出失败原因
* 第二部分的变量名为value，表示返回结果的内容；
*****************************************************************************************************/
enum ThriftResult
{
  SUCCESS,           /*成功*/
  SERVER_UNWORKING,  /*服务器处于非Working状态*/
  NO_CONTENT,  		 /*请求结果不存在*/
  PARAMETER_ERROR,	 /*参数错误*/
  EXCEPTION,	 	 /*内部出现异常*/
  INDEX_ERROR,		 /*错误的索引或者下标值*/
  UNKNOWN_ERROR 	 /*未知错误*/
  DATA_NOT_COMPLETE 	 /*数据不完全*/
  INNER_ERROR 	 /*内部错误*/
}

/*bool类型返回结果*/
struct ResultBool
{
  1: ThriftResult result,
  2: bool value
}

/*int类型返回结果*/
struct ResultInt
{
  1: ThriftResult result,
  2: i32 value
}

/*String类型返回结果*/
struct ResultStr
{
  1: ThriftResult result,
  2: string value
}

/*long类型返回结果*/
struct ResultLong
{
  1: ThriftResult result,
  2: i64 value
}



/*double类型返回结果*/
struct ResultDouble
{
  1: ThriftResult result,
  2: double value
}

/*list<string>类型返回结果*/
struct ResultListStr
{
  1: ThriftResult result,
  2: list<string> value
}

/*Set<string>类型返回结果*/
struct ResultSetStr
{
  1: ThriftResult result,
  2: set<string> value
}

/*map<string,string>类型返回结果*/
struct ResultMapStrStr
{
  1: ThriftResult result,
  2: map<string,string> value
}