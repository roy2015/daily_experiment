namespace java com.roy.miscellaneous.thrift.service

include "dto.thrift"

service TestThriftService
{

	/**
	*value 中存放两个字符串拼接之后的字符串
	*/
	 dto.ResultStr getStr(1:string srcStr1, 2:string srcStr2),

	dto.ResultInt getInt(1:i32 val)

}