package com.liby.bytecode.handler;

import java.nio.ByteBuffer;

public interface ConstantInfoHandler {

    void read(ByteBuffer codeBuf) throws Exception;

}
