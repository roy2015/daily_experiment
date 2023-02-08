// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: student.proto

package com.roy.example.proto.dto;

public final class StudentProto {
  private StudentProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface StudentOrBuilder extends
      // @@protoc_insertion_point(interface_extends:com.roy.example.proto.dto.Student)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>required int32 sid = 1;</code>
     */
    boolean hasSid();
    /**
     * <code>required int32 sid = 1;</code>
     */
    int getSid();

    /**
     * <code>required string sName = 2;</code>
     */
    boolean hasSName();
    /**
     * <code>required string sName = 2;</code>
     */
    java.lang.String getSName();
    /**
     * <code>required string sName = 2;</code>
     */
    com.google.protobuf.ByteString
        getSNameBytes();

    /**
     * <code>required bool sex = 3;</code>
     */
    boolean hasSex();
    /**
     * <code>required bool sex = 3;</code>
     */
    boolean getSex();

    /**
     * <code>required int32 age = 4;</code>
     */
    boolean hasAge();
    /**
     * <code>required int32 age = 4;</code>
     */
    int getAge();

    /**
     * <code>optional string phoneNumber = 5;</code>
     */
    boolean hasPhoneNumber();
    /**
     * <code>optional string phoneNumber = 5;</code>
     */
    java.lang.String getPhoneNumber();
    /**
     * <code>optional string phoneNumber = 5;</code>
     */
    com.google.protobuf.ByteString
        getPhoneNumberBytes();
  }
  /**
   * Protobuf type {@code com.roy.example.proto.dto.Student}
   */
  public  static final class Student extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:com.roy.example.proto.dto.Student)
      StudentOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use Student.newBuilder() to construct.
    private Student(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Student() {
      sid_ = 0;
      sName_ = "";
      sex_ = false;
      age_ = 0;
      phoneNumber_ = "";
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private Student(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 8: {
              bitField0_ |= 0x00000001;
              sid_ = input.readInt32();
              break;
            }
            case 18: {
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000002;
              sName_ = bs;
              break;
            }
            case 24: {
              bitField0_ |= 0x00000004;
              sex_ = input.readBool();
              break;
            }
            case 32: {
              bitField0_ |= 0x00000008;
              age_ = input.readInt32();
              break;
            }
            case 42: {
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000010;
              phoneNumber_ = bs;
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.roy.example.proto.dto.StudentProto.internal_static_com_roy_example_proto_dto_Student_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.roy.example.proto.dto.StudentProto.internal_static_com_roy_example_proto_dto_Student_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.roy.example.proto.dto.StudentProto.Student.class, com.roy.example.proto.dto.StudentProto.Student.Builder.class);
    }

    private int bitField0_;
    public static final int SID_FIELD_NUMBER = 1;
    private int sid_;
    /**
     * <code>required int32 sid = 1;</code>
     */
    public boolean hasSid() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required int32 sid = 1;</code>
     */
    public int getSid() {
      return sid_;
    }

    public static final int SNAME_FIELD_NUMBER = 2;
    private volatile java.lang.Object sName_;
    /**
     * <code>required string sName = 2;</code>
     */
    public boolean hasSName() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>required string sName = 2;</code>
     */
    public java.lang.String getSName() {
      java.lang.Object ref = sName_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          sName_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string sName = 2;</code>
     */
    public com.google.protobuf.ByteString
        getSNameBytes() {
      java.lang.Object ref = sName_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        sName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int SEX_FIELD_NUMBER = 3;
    private boolean sex_;
    /**
     * <code>required bool sex = 3;</code>
     */
    public boolean hasSex() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>required bool sex = 3;</code>
     */
    public boolean getSex() {
      return sex_;
    }

    public static final int AGE_FIELD_NUMBER = 4;
    private int age_;
    /**
     * <code>required int32 age = 4;</code>
     */
    public boolean hasAge() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <code>required int32 age = 4;</code>
     */
    public int getAge() {
      return age_;
    }

    public static final int PHONENUMBER_FIELD_NUMBER = 5;
    private volatile java.lang.Object phoneNumber_;
    /**
     * <code>optional string phoneNumber = 5;</code>
     */
    public boolean hasPhoneNumber() {
      return ((bitField0_ & 0x00000010) == 0x00000010);
    }
    /**
     * <code>optional string phoneNumber = 5;</code>
     */
    public java.lang.String getPhoneNumber() {
      java.lang.Object ref = phoneNumber_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          phoneNumber_ = s;
        }
        return s;
      }
    }
    /**
     * <code>optional string phoneNumber = 5;</code>
     */
    public com.google.protobuf.ByteString
        getPhoneNumberBytes() {
      java.lang.Object ref = phoneNumber_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        phoneNumber_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      if (!hasSid()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasSName()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasSex()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasAge()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeInt32(1, sid_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, sName_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        output.writeBool(3, sex_);
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        output.writeInt32(4, age_);
      }
      if (((bitField0_ & 0x00000010) == 0x00000010)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 5, phoneNumber_);
      }
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, sid_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, sName_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBoolSize(3, sex_);
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(4, age_);
      }
      if (((bitField0_ & 0x00000010) == 0x00000010)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, phoneNumber_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof com.roy.example.proto.dto.StudentProto.Student)) {
        return super.equals(obj);
      }
      com.roy.example.proto.dto.StudentProto.Student other = (com.roy.example.proto.dto.StudentProto.Student) obj;

      boolean result = true;
      result = result && (hasSid() == other.hasSid());
      if (hasSid()) {
        result = result && (getSid()
            == other.getSid());
      }
      result = result && (hasSName() == other.hasSName());
      if (hasSName()) {
        result = result && getSName()
            .equals(other.getSName());
      }
      result = result && (hasSex() == other.hasSex());
      if (hasSex()) {
        result = result && (getSex()
            == other.getSex());
      }
      result = result && (hasAge() == other.hasAge());
      if (hasAge()) {
        result = result && (getAge()
            == other.getAge());
      }
      result = result && (hasPhoneNumber() == other.hasPhoneNumber());
      if (hasPhoneNumber()) {
        result = result && getPhoneNumber()
            .equals(other.getPhoneNumber());
      }
      result = result && unknownFields.equals(other.unknownFields);
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      if (hasSid()) {
        hash = (37 * hash) + SID_FIELD_NUMBER;
        hash = (53 * hash) + getSid();
      }
      if (hasSName()) {
        hash = (37 * hash) + SNAME_FIELD_NUMBER;
        hash = (53 * hash) + getSName().hashCode();
      }
      if (hasSex()) {
        hash = (37 * hash) + SEX_FIELD_NUMBER;
        hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
            getSex());
      }
      if (hasAge()) {
        hash = (37 * hash) + AGE_FIELD_NUMBER;
        hash = (53 * hash) + getAge();
      }
      if (hasPhoneNumber()) {
        hash = (37 * hash) + PHONENUMBER_FIELD_NUMBER;
        hash = (53 * hash) + getPhoneNumber().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.roy.example.proto.dto.StudentProto.Student parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.roy.example.proto.dto.StudentProto.Student parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.roy.example.proto.dto.StudentProto.Student parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.roy.example.proto.dto.StudentProto.Student parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.roy.example.proto.dto.StudentProto.Student parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.roy.example.proto.dto.StudentProto.Student parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.roy.example.proto.dto.StudentProto.Student parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.roy.example.proto.dto.StudentProto.Student parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.roy.example.proto.dto.StudentProto.Student parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.roy.example.proto.dto.StudentProto.Student parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.roy.example.proto.dto.StudentProto.Student parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.roy.example.proto.dto.StudentProto.Student parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(com.roy.example.proto.dto.StudentProto.Student prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code com.roy.example.proto.dto.Student}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:com.roy.example.proto.dto.Student)
        com.roy.example.proto.dto.StudentProto.StudentOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.roy.example.proto.dto.StudentProto.internal_static_com_roy_example_proto_dto_Student_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.roy.example.proto.dto.StudentProto.internal_static_com_roy_example_proto_dto_Student_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.roy.example.proto.dto.StudentProto.Student.class, com.roy.example.proto.dto.StudentProto.Student.Builder.class);
      }

      // Construct using com.roy.example.proto.dto.StudentProto.Student.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        sid_ = 0;
        bitField0_ = (bitField0_ & ~0x00000001);
        sName_ = "";
        bitField0_ = (bitField0_ & ~0x00000002);
        sex_ = false;
        bitField0_ = (bitField0_ & ~0x00000004);
        age_ = 0;
        bitField0_ = (bitField0_ & ~0x00000008);
        phoneNumber_ = "";
        bitField0_ = (bitField0_ & ~0x00000010);
        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.roy.example.proto.dto.StudentProto.internal_static_com_roy_example_proto_dto_Student_descriptor;
      }

      public com.roy.example.proto.dto.StudentProto.Student getDefaultInstanceForType() {
        return com.roy.example.proto.dto.StudentProto.Student.getDefaultInstance();
      }

      public com.roy.example.proto.dto.StudentProto.Student build() {
        com.roy.example.proto.dto.StudentProto.Student result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.roy.example.proto.dto.StudentProto.Student buildPartial() {
        com.roy.example.proto.dto.StudentProto.Student result = new com.roy.example.proto.dto.StudentProto.Student(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.sid_ = sid_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.sName_ = sName_;
        if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
          to_bitField0_ |= 0x00000004;
        }
        result.sex_ = sex_;
        if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
          to_bitField0_ |= 0x00000008;
        }
        result.age_ = age_;
        if (((from_bitField0_ & 0x00000010) == 0x00000010)) {
          to_bitField0_ |= 0x00000010;
        }
        result.phoneNumber_ = phoneNumber_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.roy.example.proto.dto.StudentProto.Student) {
          return mergeFrom((com.roy.example.proto.dto.StudentProto.Student)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.roy.example.proto.dto.StudentProto.Student other) {
        if (other == com.roy.example.proto.dto.StudentProto.Student.getDefaultInstance()) return this;
        if (other.hasSid()) {
          setSid(other.getSid());
        }
        if (other.hasSName()) {
          bitField0_ |= 0x00000002;
          sName_ = other.sName_;
          onChanged();
        }
        if (other.hasSex()) {
          setSex(other.getSex());
        }
        if (other.hasAge()) {
          setAge(other.getAge());
        }
        if (other.hasPhoneNumber()) {
          bitField0_ |= 0x00000010;
          phoneNumber_ = other.phoneNumber_;
          onChanged();
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        if (!hasSid()) {
          return false;
        }
        if (!hasSName()) {
          return false;
        }
        if (!hasSex()) {
          return false;
        }
        if (!hasAge()) {
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.roy.example.proto.dto.StudentProto.Student parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.roy.example.proto.dto.StudentProto.Student) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private int sid_ ;
      /**
       * <code>required int32 sid = 1;</code>
       */
      public boolean hasSid() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required int32 sid = 1;</code>
       */
      public int getSid() {
        return sid_;
      }
      /**
       * <code>required int32 sid = 1;</code>
       */
      public Builder setSid(int value) {
        bitField0_ |= 0x00000001;
        sid_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required int32 sid = 1;</code>
       */
      public Builder clearSid() {
        bitField0_ = (bitField0_ & ~0x00000001);
        sid_ = 0;
        onChanged();
        return this;
      }

      private java.lang.Object sName_ = "";
      /**
       * <code>required string sName = 2;</code>
       */
      public boolean hasSName() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>required string sName = 2;</code>
       */
      public java.lang.String getSName() {
        java.lang.Object ref = sName_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            sName_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string sName = 2;</code>
       */
      public com.google.protobuf.ByteString
          getSNameBytes() {
        java.lang.Object ref = sName_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          sName_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string sName = 2;</code>
       */
      public Builder setSName(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        sName_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string sName = 2;</code>
       */
      public Builder clearSName() {
        bitField0_ = (bitField0_ & ~0x00000002);
        sName_ = getDefaultInstance().getSName();
        onChanged();
        return this;
      }
      /**
       * <code>required string sName = 2;</code>
       */
      public Builder setSNameBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        sName_ = value;
        onChanged();
        return this;
      }

      private boolean sex_ ;
      /**
       * <code>required bool sex = 3;</code>
       */
      public boolean hasSex() {
        return ((bitField0_ & 0x00000004) == 0x00000004);
      }
      /**
       * <code>required bool sex = 3;</code>
       */
      public boolean getSex() {
        return sex_;
      }
      /**
       * <code>required bool sex = 3;</code>
       */
      public Builder setSex(boolean value) {
        bitField0_ |= 0x00000004;
        sex_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required bool sex = 3;</code>
       */
      public Builder clearSex() {
        bitField0_ = (bitField0_ & ~0x00000004);
        sex_ = false;
        onChanged();
        return this;
      }

      private int age_ ;
      /**
       * <code>required int32 age = 4;</code>
       */
      public boolean hasAge() {
        return ((bitField0_ & 0x00000008) == 0x00000008);
      }
      /**
       * <code>required int32 age = 4;</code>
       */
      public int getAge() {
        return age_;
      }
      /**
       * <code>required int32 age = 4;</code>
       */
      public Builder setAge(int value) {
        bitField0_ |= 0x00000008;
        age_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required int32 age = 4;</code>
       */
      public Builder clearAge() {
        bitField0_ = (bitField0_ & ~0x00000008);
        age_ = 0;
        onChanged();
        return this;
      }

      private java.lang.Object phoneNumber_ = "";
      /**
       * <code>optional string phoneNumber = 5;</code>
       */
      public boolean hasPhoneNumber() {
        return ((bitField0_ & 0x00000010) == 0x00000010);
      }
      /**
       * <code>optional string phoneNumber = 5;</code>
       */
      public java.lang.String getPhoneNumber() {
        java.lang.Object ref = phoneNumber_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            phoneNumber_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string phoneNumber = 5;</code>
       */
      public com.google.protobuf.ByteString
          getPhoneNumberBytes() {
        java.lang.Object ref = phoneNumber_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          phoneNumber_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string phoneNumber = 5;</code>
       */
      public Builder setPhoneNumber(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000010;
        phoneNumber_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string phoneNumber = 5;</code>
       */
      public Builder clearPhoneNumber() {
        bitField0_ = (bitField0_ & ~0x00000010);
        phoneNumber_ = getDefaultInstance().getPhoneNumber();
        onChanged();
        return this;
      }
      /**
       * <code>optional string phoneNumber = 5;</code>
       */
      public Builder setPhoneNumberBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000010;
        phoneNumber_ = value;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:com.roy.example.proto.dto.Student)
    }

    // @@protoc_insertion_point(class_scope:com.roy.example.proto.dto.Student)
    private static final com.roy.example.proto.dto.StudentProto.Student DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.roy.example.proto.dto.StudentProto.Student();
    }

    public static com.roy.example.proto.dto.StudentProto.Student getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    @java.lang.Deprecated public static final com.google.protobuf.Parser<Student>
        PARSER = new com.google.protobuf.AbstractParser<Student>() {
      public Student parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new Student(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Student> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Student> getParserForType() {
      return PARSER;
    }

    public com.roy.example.proto.dto.StudentProto.Student getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_roy_example_proto_dto_Student_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_roy_example_proto_dto_Student_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rstudent.proto\022\031com.roy.example.proto.d" +
      "to\"T\n\007Student\022\013\n\003sid\030\001 \002(\005\022\r\n\005sName\030\002 \002(" +
      "\t\022\013\n\003sex\030\003 \002(\010\022\013\n\003age\030\004 \002(\005\022\023\n\013phoneNumb" +
      "er\030\005 \001(\tB\016B\014StudentProto"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_com_roy_example_proto_dto_Student_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_roy_example_proto_dto_Student_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_roy_example_proto_dto_Student_descriptor,
        new java.lang.String[] { "Sid", "SName", "Sex", "Age", "PhoneNumber", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
