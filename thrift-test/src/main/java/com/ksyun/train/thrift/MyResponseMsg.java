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
public class MyResponseMsg implements org.apache.thrift.TBase<MyResponseMsg, MyResponseMsg._Fields>, java.io.Serializable, Cloneable, Comparable<MyResponseMsg> {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("MyResponseMsg");

    private static final org.apache.thrift.protocol.TField STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("status", org.apache.thrift.protocol.TType.BOOL, (short) 1);
    private static final org.apache.thrift.protocol.TField NO_FIELD_DESC = new org.apache.thrift.protocol.TField("no", org.apache.thrift.protocol.TType.I32, (short) 2);
    private static final org.apache.thrift.protocol.TField MSG_FIELD_DESC = new org.apache.thrift.protocol.TField("msg", org.apache.thrift.protocol.TType.STRING, (short) 3);

    private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new MyResponseMsgStandardSchemeFactory();
    private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new MyResponseMsgTupleSchemeFactory();

    public boolean status; // required
    public int no; // optional
    public @org.apache.thrift.annotation.Nullable java.lang.String msg; // optional

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
        STATUS((short) 1, "status"),
        NO((short) 2, "no"),
        MSG((short) 3, "msg");

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
                case 1: // STATUS
                    return STATUS;
                case 2: // NO
                    return NO;
                case 3: // MSG
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
    private static final int __STATUS_ISSET_ID = 0;
    private static final int __NO_ISSET_ID = 1;
    private byte __isset_bitfield = 0;
    private static final _Fields optionals[] = {_Fields.NO, _Fields.MSG};
    public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;

    static {
        java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
        tmpMap.put(_Fields.STATUS, new org.apache.thrift.meta_data.FieldMetaData("status", org.apache.thrift.TFieldRequirementType.DEFAULT,
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
        tmpMap.put(_Fields.NO, new org.apache.thrift.meta_data.FieldMetaData("no", org.apache.thrift.TFieldRequirementType.OPTIONAL,
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
        tmpMap.put(_Fields.MSG, new org.apache.thrift.meta_data.FieldMetaData("msg", org.apache.thrift.TFieldRequirementType.OPTIONAL,
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
        metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
        org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(MyResponseMsg.class, metaDataMap);
    }

    public MyResponseMsg() {
    }

    public MyResponseMsg(
            boolean status) {
        this();
        this.status = status;
        setStatusIsSet(true);
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public MyResponseMsg(MyResponseMsg other) {
        __isset_bitfield = other.__isset_bitfield;
        this.status = other.status;
        this.no = other.no;
        if (other.isSetMsg()) {
            this.msg = other.msg;
        }
    }

    @Override
    public MyResponseMsg deepCopy() {
        return new MyResponseMsg(this);
    }

    @Override
    public void clear() {
        setStatusIsSet(false);
        this.status = false;
        setNoIsSet(false);
        this.no = 0;
        this.msg = null;
    }

    public boolean isStatus() {
        return this.status;
    }

    public MyResponseMsg setStatus(boolean status) {
        this.status = status;
        setStatusIsSet(true);
        return this;
    }

    public void unsetStatus() {
        __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __STATUS_ISSET_ID);
    }

    /** Returns true if field status is set (has been assigned a value) and false otherwise */
    public boolean isSetStatus() {
        return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __STATUS_ISSET_ID);
    }

    public void setStatusIsSet(boolean value) {
        __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __STATUS_ISSET_ID, value);
    }

    public int getNo() {
        return this.no;
    }

    public MyResponseMsg setNo(int no) {
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

    public MyResponseMsg setMsg(@org.apache.thrift.annotation.Nullable java.lang.String msg) {
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
            case STATUS:
                if (value == null) {
                    unsetStatus();
                } else {
                    setStatus((java.lang.Boolean) value);
                }
                break;

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
            case STATUS:
                return isStatus();

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
            case STATUS:
                return isSetStatus();
            case NO:
                return isSetNo();
            case MSG:
                return isSetMsg();
        }
        throw new java.lang.IllegalStateException();
    }

    @Override
    public boolean equals(java.lang.Object that) {
        if (that instanceof MyResponseMsg)
            return this.equals((MyResponseMsg) that);
        return false;
    }

    public boolean equals(MyResponseMsg that) {
        if (that == null)
            return false;
        if (this == that)
            return true;

        boolean this_present_status = true;
        boolean that_present_status = true;
        if (this_present_status || that_present_status) {
            if (!(this_present_status && that_present_status))
                return false;
            if (this.status != that.status)
                return false;
        }

        boolean this_present_no = true && this.isSetNo();
        boolean that_present_no = true && that.isSetNo();
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

        hashCode = hashCode * 8191 + ((status) ? 131071 : 524287);

        hashCode = hashCode * 8191 + ((isSetNo()) ? 131071 : 524287);
        if (isSetNo())
            hashCode = hashCode * 8191 + no;

        hashCode = hashCode * 8191 + ((isSetMsg()) ? 131071 : 524287);
        if (isSetMsg())
            hashCode = hashCode * 8191 + msg.hashCode();

        return hashCode;
    }

    @Override
    public int compareTo(MyResponseMsg other) {
        if (!getClass().equals(other.getClass())) {
            return getClass().getName().compareTo(other.getClass().getName());
        }

        int lastComparison = 0;

        lastComparison = java.lang.Boolean.compare(isSetStatus(), other.isSetStatus());
        if (lastComparison != 0) {
            return lastComparison;
        }
        if (isSetStatus()) {
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.status, other.status);
            if (lastComparison != 0) {
                return lastComparison;
            }
        }
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
        java.lang.StringBuilder sb = new java.lang.StringBuilder("MyResponseMsg(");
        boolean first = true;

        sb.append("status:");
        sb.append(this.status);
        first = false;
        if (isSetNo()) {
            if (!first) sb.append(", ");
            sb.append("no:");
            sb.append(this.no);
            first = false;
        }
        if (isSetMsg()) {
            if (!first) sb.append(", ");
            sb.append("msg:");
            if (this.msg == null) {
                sb.append("null");
            } else {
                sb.append(this.msg);
            }
            first = false;
        }
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

    private static class MyResponseMsgStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
        @Override
        public MyResponseMsgStandardScheme getScheme() {
            return new MyResponseMsgStandardScheme();
        }
    }

    private static class MyResponseMsgStandardScheme extends org.apache.thrift.scheme.StandardScheme<MyResponseMsg> {

        @Override
        public void read(org.apache.thrift.protocol.TProtocol iprot, MyResponseMsg struct) throws org.apache.thrift.TException {
            org.apache.thrift.protocol.TField schemeField;
            iprot.readStructBegin();
            while (true) {
                schemeField = iprot.readFieldBegin();
                if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
                    break;
                }
                switch (schemeField.id) {
                    case 1: // STATUS
                        if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
                            struct.status = iprot.readBool();
                            struct.setStatusIsSet(true);
                        } else {
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;
                    case 2: // NO
                        if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
                            struct.no = iprot.readI32();
                            struct.setNoIsSet(true);
                        } else {
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;
                    case 3: // MSG
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
        public void write(org.apache.thrift.protocol.TProtocol oprot, MyResponseMsg struct) throws org.apache.thrift.TException {
            struct.validate();

            oprot.writeStructBegin(STRUCT_DESC);
            oprot.writeFieldBegin(STATUS_FIELD_DESC);
            oprot.writeBool(struct.status);
            oprot.writeFieldEnd();
            if (struct.isSetNo()) {
                oprot.writeFieldBegin(NO_FIELD_DESC);
                oprot.writeI32(struct.no);
                oprot.writeFieldEnd();
            }
            if (struct.msg != null) {
                if (struct.isSetMsg()) {
                    oprot.writeFieldBegin(MSG_FIELD_DESC);
                    oprot.writeString(struct.msg);
                    oprot.writeFieldEnd();
                }
            }
            oprot.writeFieldStop();
            oprot.writeStructEnd();
        }

    }

    private static class MyResponseMsgTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
        @Override
        public MyResponseMsgTupleScheme getScheme() {
            return new MyResponseMsgTupleScheme();
        }
    }

    private static class MyResponseMsgTupleScheme extends org.apache.thrift.scheme.TupleScheme<MyResponseMsg> {

        @Override
        public void write(org.apache.thrift.protocol.TProtocol prot, MyResponseMsg struct) throws org.apache.thrift.TException {
            org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
            java.util.BitSet optionals = new java.util.BitSet();
            if (struct.isSetStatus()) {
                optionals.set(0);
            }
            if (struct.isSetNo()) {
                optionals.set(1);
            }
            if (struct.isSetMsg()) {
                optionals.set(2);
            }
            oprot.writeBitSet(optionals, 3);
            if (struct.isSetStatus()) {
                oprot.writeBool(struct.status);
            }
            if (struct.isSetNo()) {
                oprot.writeI32(struct.no);
            }
            if (struct.isSetMsg()) {
                oprot.writeString(struct.msg);
            }
        }

        @Override
        public void read(org.apache.thrift.protocol.TProtocol prot, MyResponseMsg struct) throws org.apache.thrift.TException {
            org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
            java.util.BitSet incoming = iprot.readBitSet(3);
            if (incoming.get(0)) {
                struct.status = iprot.readBool();
                struct.setStatusIsSet(true);
            }
            if (incoming.get(1)) {
                struct.no = iprot.readI32();
                struct.setNoIsSet(true);
            }
            if (incoming.get(2)) {
                struct.msg = iprot.readString();
                struct.setMsgIsSet(true);
            }
        }
    }

    private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
        return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
    }
}

