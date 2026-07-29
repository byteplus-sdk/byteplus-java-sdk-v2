package com.byteplus.endpoint;

import com.byteplus.ApiException;

public interface EndpointResolver {

    /**
     * Resolve the endpoint for the given request option.
     *
     * @param option resolution input (service, region, dual-stack, etc.).
     * @return the resolved endpoint host.
     * @throws ApiException when resolution fails (e.g. unknown service in the
     *         default provider). {@code ApiException} is an unchecked
     *         exception, so callers are not required to declare or catch it;
     *         the declaration is kept for documentation and existing catch
     *         blocks.
     */
    public ResolvedEndpoint endpointFor(ResolveEndpointOption option) throws ApiException;

}
