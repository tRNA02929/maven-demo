/**
 * Autogenerated by Thrift Compiler (0.18.1)
 * <p>
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *
 * @generated
 */
package com.ksyun.train.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.18.1)", date = "2023-08-15")
public class MyRequestMsg implements org.apache.thrift.TBase<MyRequestMsg, MyRequestMsg._Fields>, java.io.Serializable, Cloneable, Comparable<MyRequestMsg> {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("MyRequestMsg");

    private static final org.apache.thrift.protocol.TField NO_FIELD_DESC = new org.apache.thrift.protocol.TField("no", org.apache.thrift.protocol.TType.I32, (short) 1);
    private static final org.apache.thrift.protocol.TField MSG_FIELD_DESC = new org.apache.thrift.protocol.TField("msg", org.apache.thrift.protocol.TType.STRING, (short) 2);

    private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new MyRequestMsgStandardSchemeFactory();
    private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new MyRequestMsgTupleSchemeFactory();

    public int no; // required
    public @org.apache.thrift.annotation.Nullable java.lang.String msg; // required

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
        NO((short) 1, "no"),
        MSG((short) 2, "msg");

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
                case 1: // NO
                    return NO;
                case 2: // MSG
                    return MSG;
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
    private static final int __NO_ISSET_ID = 0;
    private byte __isset_bitfield = 0;
    public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;

    static {
        java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
        tmpMap.put(_Fields.NO, new org.apache.thrift.meta_data.FieldMetaData("no", org.apache.thrift.TFieldRequirementType.DEFAULT,
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
        tmpMap.put(_Fields.MSG, new org.apache.thrift.meta_data.FieldMetaData("msg", org.apache.thrift.TFieldRequirementType.DEFAULT,
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
        metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
        org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(MyRequestMsg.class, metaDataMap);
    }

    public MyRequestMsg() {
    }

    public MyRequestMsg(
            int no,
            java.lang.String msg) {
        this();
        this.no = no;
        setNoIsSet(true);
        this.msg = msg;
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public MyRequestMsg(MyRequestMsg other) {
        __isset_bitfield = other.__isset_bitfield;
        this.no = other.no;
        if (other.isSetMsg()) {
            this.msg = other.msg;
        }
    }

    @Override
    public MyRequestMsg deepCopy() {
        return new MyRequestMsg(this);
    }

    @Override
    public void clear() {
        setNoIsSet(false);
        this.no = 0;
        this.msg = null;
    }

    public int getNo() {
        return this.no;
    }

    public MyRequestMsg setNo(int no) {
        this.no = no;
        setNoIsSet(true);
        return this;
    }

    public void unsetNo() {
        __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __NO_ISSET_ID);
    }

    /** Returns true if field no is set (has been assigned a value) and false otherwise */
    public boolean isSetNo() {
        return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __NO_ISSET_ID);
    }

    public void setNoIsSet(boolean value) {
        __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __NO_ISSET_ID, value);
    }

    @org.apache.thrift.annotation.Nullable
    public java.lang.String getMsg() {
        return this.msg;
    }

    public MyRequestMsg setMsg(@org.apache.thrift.annotation.Nullable java.lang.String msg) {
        this.msg = msg;
        return this;
    }

    public void unsetMsg() {
        this.msg = null;
    }

    /** Returns true if field msg is set (has been assigned a value) and false otherwise */
    public boolean isSetMsg() {
        return this.msg != null;
    }

    public void setMsgIsSet(boolean value) {
        if (!value) {
            this.msg = null;
        }
    }

    @Override
    public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
        switch (field) {
            case NO:
                if (value == null) {
                    unsetNo();
                } else {
                    setNo((java.lang.Integer) value);
                }
                break;

            case MSG:
                if (value == null) {
                    unsetMsg();
                } else {
                    setMsg((java.lang.String) value);
                }
                break;

        }
    }

    @org.apache.thrift.annotation.Nullable
    @Override
    public java.lang.Object getFieldValue(_Fields field) {
        switch (field) {
            case NO:
                return getNo();

            case MSG:
                return getMsg();

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
            case NO:
                return isSetNo();
            case MSG:
                return isSetMsg();
        }
        throw new java.lang.IllegalStateException();
    }

    @Override
    public boolean equals(java.lang.Object that) {
        if (that instanceof MyRequestMsg)
            return this.equals((MyRequestMsg) that);
        return false;
    }

    public boolean equals(MyRequestMsg that) {
        if (that == null)
            return false;
        if (this == that)
            return true;

        boolean this_present_no = true;
        boolean that_present_no = true;
        if (this_present_no || that_present_no) {
            if (!(this_present_no && that_present_no))
                return false;
            if (this.no != that.no)
                return false;
        }

        boolean this_present_msg = true && this.isSetMsg();
        boolean that_present_msg = true && that.isSetMsg();
        if (this_present_msg || that_present_msg) {
            if (!(this_present_msg && that_present_msg))
                return false;
            if (!this.msg.equals(that.msg))
                return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hashCode = 1;

        hashCode = hashCode * 8191 + no;

        hashCode = hashCode * 8191 + ((isSetMsg()) ? 131071 : 524287);
        if (isSetMsg())
            hashCode = hashCode * 8191 + msg.hashCode();

        return hashCode;
    }

    @Override
    public int compareTo(MyRequestMsg other) {
        if (!getClass().equals(other.getClass())) {
            return getClass().getName().compareTo(other.getClass().getName());
        }

        int lastComparison = 0;

        lastComparison = java.lang.Boolean.compare(isSetNo(), other.isSetNo());
        if (lastComparison != 0) {
            return lastComparison;
        }
        if (isSetNo()) {
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.no, other.no);
            if (lastComparison != 0) {
                return lastComparison;
            }
        }
        lastComparison = java.lang.Boolean.compare(isSetMsg(), other.isSetMsg());
        if (lastComparison != 0) {
            return lastComparison;
        }
        if (isSetMsg()) {
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.msg, other.msg);
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
        java.lang.StringBuilder sb = new java.lang.StringBuilder("MyRequestMsg(");
        boolean first = true;

        sb.append("no:");
        sb.append(this.no);
        first = false;
        if (!first) sb.append(", ");
        sb.append("msg:");
        if (this.msg == null) {
            sb.append("null");
        } else {
            sb.append(this.msg);
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
            // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
            __isset_bitfield = 0;
            read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
        } catch (org.apache.thrift.TException te) {
            throw new java.io.IOException(te);
        }
    }

    private static class MyRequestMsgStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
        @Override
        public MyRequestMsgStandardScheme getScheme() {
            return new MyRequestMsgStandardScheme();
        }
    }

    private static class MyRequestMsgStandardScheme extends org.apache.thrift.scheme.StandardScheme<MyRequestMsg> {

        @Override
        public void read(org.apache.thrift.protocol.TProtocol iprot, MyRequestMsg struct) throws org.apache.thrift.TException {
            org.apache.thrift.protocol.TField schemeField;
            iprot.readStructBegin();
            while (true) {
                schemeField = iprot.readFieldBegin();
                if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
                    break;
                }
                switch (schemeField.id) {
                    case 1: // NO
                        if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
                            struct.no = iprot.readI32();
                            struct.setNoIsSet(true);
                        } else {
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;
                    case 2: // MSG
                        if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                            struct.msg = iprot.readString();
                            struct.setMsgIsSet(true);
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
        public void write(org.apache.thrift.protocol.TProtocol oprot, MyRequestMsg struct) throws org.apache.thrift.TException {
            struct.validate();

            oprot.writeStructBegin(STRUCT_DESC);
            oprot.writeFieldBegin(NO_FIELD_DESC);
            oprot.writeI32(struct.no);
            oprot.writeFieldEnd();
            if (struct.msg != null) {
                oprot.writeFieldBegin(MSG_FIELD_DESC);
                oprot.writeString(struct.msg);
                oprot.writeFieldEnd();
            }
            oprot.writeFieldStop();
            oprot.writeStructEnd();
        }

    }

    private static class MyRequestMsgTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
        @Override
        public MyRequestMsgTupleScheme getScheme() {
            return new MyRequestMsgTupleScheme();
        }
    }

    private static class MyRequestMsgTupleScheme extends org.apache.thrift.scheme.TupleScheme<MyRequestMsg> {

        @Override
        public void write(org.apache.thrift.protocol.TProtocol prot, MyRequestMsg struct) throws org.apache.thrift.TException {
            org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
            java.util.BitSet optionals = new java.util.BitSet();
            if (struct.isSetNo()) {
                optionals.set(0);
            }
            if (struct.isSetMsg()) {
                optionals.set(1);
            }
            oprot.writeBitSet(optionals, 2);
            if (struct.isSetNo()) {
                oprot.writeI32(struct.no);
            }
            if (struct.isSetMsg()) {
                oprot.writeString(struct.msg);
            }
        }

        @Override
        public void read(org.apache.thrift.protocol.TProtocol prot, MyRequestMsg struct) throws org.apache.thrift.TException {
            org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
            java.util.BitSet incoming = iprot.readBitSet(2);
            if (incoming.get(0)) {
                struct.no = iprot.readI32();
                struct.setNoIsSet(true);
            }
            if (incoming.get(1)) {
                struct.msg = iprot.readString();
                struct.setMsgIsSet(true);
            }
        }
    }

    private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
        return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
    }
}
