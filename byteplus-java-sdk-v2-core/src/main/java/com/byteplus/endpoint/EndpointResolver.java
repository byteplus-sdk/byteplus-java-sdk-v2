package com.byteplus.endpoint;

import com.byteplus.ApiException;

public interface EndpointResolver {

    public ResolvedEndpoint endpointFor(ResolveEndpointOption option) throws ApiException;

}
