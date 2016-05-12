package ru.itis.inform.users.client.api;

public class UsersClient_Generated_RestServiceProxy_ implements ru.itis.inform.users.client.api.UsersClient, org.fusesource.restygwt.client.RestServiceProxy {
  private org.fusesource.restygwt.client.Resource resource = null;
  
  public void setResource(org.fusesource.restygwt.client.Resource resource) {
    this.resource = resource;
  }
  public org.fusesource.restygwt.client.Resource getResource() {
    if (this.resource == null) {
      String serviceRoot = org.fusesource.restygwt.client.Defaults.getServiceRoot();
      this.resource = new org.fusesource.restygwt.client.Resource(serviceRoot).resolve("/signup");
    }
    return this.resource;
  }
  private org.fusesource.restygwt.client.Dispatcher dispatcher = null;
  
  public void setDispatcher(org.fusesource.restygwt.client.Dispatcher dispatcher) {
    this.dispatcher = dispatcher;
  }
  
  public org.fusesource.restygwt.client.Dispatcher getDispatcher() {
    return this.dispatcher;
  }
  public void addUser(ru.itis.inform.users.models.UserDto dto, org.fusesource.restygwt.client.MethodCallback<java.lang.String> callback) {
    final ru.itis.inform.users.models.UserDto final_dto = dto;
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .post();
    __method.setDispatcher(this.dispatcher);
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_ACCEPT, org.fusesource.restygwt.client.Resource.CONTENT_TYPE_JSON);
    __method.json(ru.itis.inform.users.models.UserDto_Generated_JsonEncoderDecoder_.INSTANCE.encode(dto));
    try {
      __method.send(new org.fusesource.restygwt.client.AbstractRequestCallback<java.lang.String>(__method, callback) {
        protected java.lang.String parseResult() throws Exception {
          try {
            return org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.decode(com.google.gwt.json.client.JSONParser.parse(__method.getResponse().getText()));
          } catch (Throwable __e) {
            throw new org.fusesource.restygwt.client.ResponseFormatException("Response was NOT a valid JSON document", __e);
          }
        }
      });
    } catch (com.google.gwt.http.client.RequestException __e) {
      callback.onFailure(__method,__e);
    }
  }
}
