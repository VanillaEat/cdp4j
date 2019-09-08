/**
 * cdp4j Commercial License
 *
 * Copyright 2017, 2019 WebFolder OÜ
 *
 * Permission  is hereby  granted,  to "____" obtaining  a  copy of  this software  and
 * associated  documentation files  (the "Software"), to deal in  the Software  without
 * restriction, including without limitation  the rights  to use, copy, modify,  merge,
 * publish, distribute  and sublicense  of the Software,  and to permit persons to whom
 * the Software is furnished to do so, subject to the following conditions:
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR  IMPLIED,
 * INCLUDING  BUT NOT  LIMITED  TO THE  WARRANTIES  OF  MERCHANTABILITY, FITNESS  FOR A
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL  THE AUTHORS  OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.webfolder.cdp.type.runtime;

import java.util.List;

import com.vimeo.stag.UseStag;

@UseStag
public class GetPropertiesResult {
    private List<PropertyDescriptor> result;

    private List<InternalPropertyDescriptor> internalProperties;

    private List<PrivatePropertyDescriptor> privateProperties;

    private ExceptionDetails exceptionDetails;

    public List<PropertyDescriptor> getResult() {
        return result;
    }

    public List<InternalPropertyDescriptor> getInternalProperties() {
        return internalProperties;
    }

    public List<PrivatePropertyDescriptor> getPrivateProperties() {
        return privateProperties;
    }

    public ExceptionDetails getExceptionDetails() {
        return exceptionDetails;
    }

    public void setResult(List<PropertyDescriptor> result) {
        this.result = result;
    }

    public void setInternalProperties(List<InternalPropertyDescriptor> internalProperties) {
        this.internalProperties = internalProperties;
    }

    public void setPrivateProperties(List<PrivatePropertyDescriptor> privateProperties) {
        this.privateProperties = privateProperties;
    }

    public void setExceptionDetails(ExceptionDetails exceptionDetails) {
        this.exceptionDetails = exceptionDetails;
    }
}
