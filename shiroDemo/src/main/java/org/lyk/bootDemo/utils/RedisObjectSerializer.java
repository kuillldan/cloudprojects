package org.lyk.bootDemo.utils;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.util.Objects;

/**
 * Created by yuankliu on 06/05/2018.
 */
public class RedisObjectSerializer implements RedisSerializer<Object>
{
    private static final byte[] EMPTY_ARRAY = new byte[0];
    private Converter<Object,byte[]> serializeConverter = new SerializingConverter();
    private Converter<byte[],Object> deserializeConverter = new DeserializingConverter();

    @Override
    public byte[] serialize(Object o) throws SerializationException
    {
        if(Objects.isNull(o))
        {
            return EMPTY_ARRAY;
        }

        return this.serializeConverter.convert(o);
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException
    {
        if(Objects.isNull(bytes) || bytes.length <= 0)
        {
            return null;
        }
        return this.deserializeConverter.convert(bytes);
    }
}
