package com.ksc.urltopn.Service;

import com.ksc.urltopn.thrift.UrlTopNAppRequest;
import com.ksc.urltopn.thrift.UrlTopNAppResponse;
import com.ksc.urltopn.thrift.UrlTopNResult;
import com.ksc.urltopn.thrift.UrlTopNService;
import org.apache.thrift.TException;

import java.util.List;

public class UrlService implements UrlTopNService.Iface {
    @Override
    public UrlTopNAppResponse submitApp(UrlTopNAppRequest urlTopNAppRequest) throws TException {
        UrlTopNAppResponse urlTopNAppResponse = new UrlTopNAppResponse(urlTopNAppRequest.applicationId, 0);
        return urlTopNAppResponse;
    }

    @Override
    public UrlTopNAppResponse getAppStatus(String applicationId) throws TException {
        return null;
    }

    @Override
    public List<UrlTopNResult> getTopNAppResult(String applicationId) throws TException {
        return null;
    }
}
