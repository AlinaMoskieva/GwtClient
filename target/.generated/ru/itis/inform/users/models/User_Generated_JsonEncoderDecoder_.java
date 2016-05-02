package ru.itis.inform.users.models;

public class User_Generated_JsonEncoderDecoder_ extends org.fusesource.restygwt.client.AbstractJsonEncoderDecoder<ru.itis.inform.users.models.User> {
  
  public static final User_Generated_JsonEncoderDecoder_ INSTANCE = new User_Generated_JsonEncoderDecoder_();
  
  public com.google.gwt.json.client.JSONValue encode(ru.itis.inform.users.models.User value) {
    if( value==null ) {
      return getNullType();
    }
    com.google.gwt.json.client.JSONObject rc = new com.google.gwt.json.client.JSONObject();
    ru.itis.inform.users.models.User parseValue = (ru.itis.inform.users.models.User)value;
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.INT.encode(parseValue.getId()), rc, "id");
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.encode(parseValue.getName()), rc, "name");
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.INT.encode(parseValue.getAge()), rc, "age");
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.encode(parseValue.getSex()), rc, "sex");
    return rc;
  }
  
  public User decode(com.google.gwt.json.client.JSONValue value) {
    if( value == null || value.isNull()!=null ) {
      return null;
    }
    com.google.gwt.json.client.JSONObject object = toObject(value);
    ru.itis.inform.users.models.User rc = new ru.itis.inform.users.models.User();
    rc.setId(getValueToSet(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.INT.decode(object.get("id")), 0));
    rc.setName(getValueToSet(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.decode(object.get("name")), null));
    rc.setAge(getValueToSet(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.INT.decode(object.get("age")), 0));
    rc.setSex(getValueToSet(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.decode(object.get("sex")), null));
    return rc;
  }
  
}
