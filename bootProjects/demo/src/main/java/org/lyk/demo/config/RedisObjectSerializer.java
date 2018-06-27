package org.lyk.demo.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.util.Objects;

/**
 * Created by yuankliu on 16/05/2018.
 */
public class RedisObjectSerializer implements RedisSerializer<Object>
{
    private Converter<Object, byte[]> serializer = new SerializingConverter();
    private Converter<byte[], Object> deserializer = new DeserializingConverter();

    @Override
    public byte[] serialize(Object o) throws SerializationException
    {
        if (Objects.isNull(o))
        {
            return new byte[0];
        }

        return this.serializer.convert(o);
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException
    {
        if (Objects.isNull(bytes) || bytes.length <= 0)
        {
            return null;
        }
        return this.deserializer.convert(bytes);
    }
}
