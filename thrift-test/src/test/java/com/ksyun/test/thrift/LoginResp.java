/**
 * Autogenerated by Thrift Compiler (0.18.1)
 * <p>
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *
 * @generated
 */
package com.ksyun.test.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.18.1)", date = "2023-08-15")
public class LoginResp implements org.apache.thrift.TBase<LoginResp, LoginResp._Fields>, java.io.Serializable, Cloneable, Comparable<LoginResp> {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("LoginResp");

    private static final org.apache.thrift.protocol.TField TOKEN_FIELD_DESC = new org.apache.thrift.protocol.TField("token", org.apache.thrift.protocol.TType.STRING, (short) 1);

    private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new LoginRespStandardSchemeFactory();
    private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new LoginRespTupleSchemeFactory();

    public @org.apache.thrift.annotation.Nullable java.lang.String token; // required

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
        TOKEN((short) 1, "token");

        private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

        static {
            for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
                byName.put(field.getFieldName(), field);
            }
        }

        /**
         * Find the _Fields constant that matches fieldId, or null if its not found.
         */
        @org.apache.thrift.annotation.Nullable
        public static _Fields findByThriftId(int fieldId) {
            switch (fieldId) {
                case 1: // TOKEN
                    return TOKEN;
                default:
                    return null;
            }
        }

        /**
         * Find the _Fields constant that matches fieldId, throwing an exception
         * if it is not found.
         */
        public static _Fields findByThriftIdOrThrow(int fieldId) {
            _Fields fields = findByThriftId(fieldId);
            if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
            return fields;
        }

        /**
         * Find the _Fields constant that matches name, or null if its not found.
         */
        @org.apache.thrift.annotation.Nullable
        public static _Fields findByName(java.lang.String name) {
            return byName.get(name);
        }

        private final short _thriftId;
        private final java.lang.String _fieldName;

        _Fields(short thriftId, java.lang.String fieldName) {
            _thriftId = thriftId;
            _fieldName = fieldName;
        }

        @Override
        public short getThriftFieldId() {
            return _thriftId;
        }

        @Override
        public java.lang.String getFieldName() {
            return _fieldName;
        }
    }

    // isset id assignments
    public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;

    static {
        java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
        tmpMap.put(_Fields.TOKEN, new org.apache.thrift.meta_data.FieldMetaData("token", org.apache.thrift.TFieldRequirementType.DEFAULT,
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
        metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
        org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(LoginResp.class, metaDataMap);
    }

    public LoginResp() {
    }

    public LoginResp(
            java.lang.String token) {
        this();
        this.token = token;
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public LoginResp(LoginResp other) {
        if (other.isSetToken()) {
            this.token = other.token;
        }
    }

    @Override
    public LoginResp deepCopy() {
        return new LoginResp(this);
    }

    @Override
    public void clear() {
        this.token = null;
    }

    @org.apache.thrift.annotation.Nullable
    public java.lang.String getToken() {
        return this.token;
    }

    public LoginResp setToken(@org.apache.thrift.annotation.Nullable java.lang.String token) {
        this.token = token;
        return this;
    }

    public void unsetToken() {
        this.token = null;
    }

    /** Returns true if field token is set (has been assigned a value) and false otherwise */
    public boolean isSetToken() {
        return this.token != null;
    }

    public void setTokenIsSet(boolean value) {
        if (!value) {
            this.token = null;
        }
    }

    @Override
    public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
        switch (field) {
            case TOKEN:
                if (value == null) {
                    unsetToken();
                } else {
                    setToken((java.lang.String) value);
                }
                break;

        }
    }

    @org.apache.thrift.annotation.Nullable
    @Override
    public java.lang.Object getFieldValue(_Fields field) {
        switch (field) {
            case TOKEN:
                return getToken();

        }
        throw new java.lang.IllegalStateException();
    }

    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
    @Override
    public boolean isSet(_Fields field) {
        if (field == null) {
            throw new java.lang.IllegalArgumentException();
        }

        switch (field) {
            case TOKEN:
                return isSetToken();
        }
        throw new java.lang.IllegalStateException();
    }

    @Override
    public boolean equals(java.lang.Object that) {
        if (that instanceof LoginResp)
            return this.equals((LoginResp) that);
        return false;
    }

    public boolean equals(LoginResp that) {
        if (that == null)
            return false;
        if (this == that)
            return true;

        boolean this_present_token = true && this.isSetToken();
        boolean that_present_token = true && that.isSetToken();
        if (this_present_token || that_present_token) {
            if (!(this_present_token && that_present_token))
                return false;
            if (!this.token.equals(that.token))
                return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hashCode = 1;

        hashCode = hashCode * 8191 + ((isSetToken()) ? 131071 : 524287);
        if (isSetToken())
            hashCode = hashCode * 8191 + token.hashCode();

        return hashCode;
    }

    @Override
    public int compareTo(LoginResp other) {
        if (!getClass().equals(other.getClass())) {
            return getClass().getName().compareTo(other.getClass().getName());
        }

        int lastComparison = 0;

        lastComparison = java.lang.Boolean.compare(isSetToken(), other.isSetToken());
        if (lastComparison != 0) {
            return lastComparison;
        }
        if (isSetToken()) {
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.token, other.token);
            if (lastComparison != 0) {
                return lastComparison;
            }
        }
        return 0;
    }

    @org.apache.thrift.annotation.Nullable
    @Override
    public _Fields fieldForId(int fieldId) {
        return _Fields.findByThriftId(fieldId);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
        scheme(iprot).read(iprot, this);
    }

    @Override
    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
        scheme(oprot).write(oprot, this);
    }

    @Override
    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("LoginResp(");
        boolean first = true;

        sb.append("token:");
        if (this.token == null) {
            sb.append("null");
        } else {
            sb.append(this.token);
        }
        first = false;
        sb.append(")");
        return sb.toString();
    }

    public void validate() throws org.apache.thrift.TException {
        // check for required fields
        // check for sub-struct validity
    }

    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
        try {
            write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
        } catch (org.apache.thrift.TException te) {
            throw new java.io.IOException(te);
        }
    }

    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
        try {
            read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
        } catch (org.apache.thrift.TException te) {
            throw new java.io.IOException(te);
        }
    }

    private static class LoginRespStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
        @Override
        public LoginRespStandardScheme getScheme() {
            return new LoginRespStandardScheme();
        }
    }

    private static class LoginRespStandardScheme extends org.apache.thrift.scheme.StandardScheme<LoginResp> {

        @Override
        public void read(org.apache.thrift.protocol.TProtocol iprot, LoginResp struct) throws org.apache.thrift.TException {
            org.apache.thrift.protocol.TField schemeField;
            iprot.readStructBegin();
            while (true) {
                schemeField = iprot.readFieldBegin();
                if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
                    break;
                }
                switch (schemeField.id) {
                    case 1: // TOKEN
                        if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                            struct.token = iprot.readString();
                            struct.setTokenIsSet(true);
                        } else {
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;
                    default:
                        org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                }
                iprot.readFieldEnd();
            }
            iprot.readStructEnd();

            // check for required fields of primitive type, which can't be checked in the validate method
            struct.validate();
        }

        @Override
        public void write(org.apache.thrift.protocol.TProtocol oprot, LoginResp struct) throws org.apache.thrift.TException {
            struct.validate();

            oprot.writeStructBegin(STRUCT_DESC);
            if (struct.token != null) {
                oprot.writeFieldBegin(TOKEN_FIELD_DESC);
                oprot.writeString(struct.token);
                oprot.writeFieldEnd();
            }
            oprot.writeFieldStop();
            oprot.writeStructEnd();
        }

    }

    private static class LoginRespTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
        @Override
        public LoginRespTupleScheme getScheme() {
            return new LoginRespTupleScheme();
        }
    }

    private static class LoginRespTupleScheme extends org.apache.thrift.scheme.TupleScheme<LoginResp> {

        @Override
        public void write(org.apache.thrift.protocol.TProtocol prot, LoginResp struct) throws org.apache.thrift.TException {
            org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
            java.util.BitSet optionals = new java.util.BitSet();
            if (struct.isSetToken()) {
                optionals.set(0);
            }
            oprot.writeBitSet(optionals, 1);
            if (struct.isSetToken()) {
                oprot.writeString(struct.token);
            }
        }

        @Override
        public void read(org.apache.thrift.protocol.TProtocol prot, LoginResp struct) throws org.apache.thrift.TException {
            org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
            java.util.BitSet incoming = iprot.readBitSet(1);
            if (incoming.get(0)) {
                struct.token = iprot.readString();
                struct.setTokenIsSet(true);
            }
        }
    }

    private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
        return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
    }
}
