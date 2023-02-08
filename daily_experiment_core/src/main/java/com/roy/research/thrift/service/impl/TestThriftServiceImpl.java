package com.roy.research.thrift.service.impl;
 
import com.roy.research.thrift.dto.ResultInt;
import com.roy.research.thrift.dto.ResultStr;
import com.roy.research.thrift.dto.ThriftResult;
import com.roy.research.thrift.service.TestThriftService;
import org.apache.thrift.TException;
 
public class TestThriftServiceImpl implements TestThriftService.Iface
{
 
	@Override
	public ResultStr getStr(String srcStr1, String srcStr2) throws TException {
		
		long startTime = System.currentTimeMillis();
		String res = srcStr1 + srcStr2; 
		long stopTime = System.currentTimeMillis();
		
		System.out.println("[getStr]time interval: " + (stopTime-startTime));
		return new ResultStr().setResult(ThriftResult.SUCCESS).setValue(res);
	}
 
	@Override
	public ResultInt getInt(int val) throws TException {
		long startTime = System.currentTimeMillis();
		int res = val * 10; 
		long stopTime = System.currentTimeMillis();
		
		System.out.println("[getInt]time interval: " + (stopTime-startTime));
        return new ResultInt().setResult(ThriftResult.SUCCESS).setValue(res);
	}
 
}