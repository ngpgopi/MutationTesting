 /*
 * Copyright 2014 Higher Frequency Trading http://www.higherfrequencytrading.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.openhft.hashing;

import static java.lang.Long.reverseBytes;
import static java.nio.ByteOrder.LITTLE_ENDIAN;
import static net.openhft.hashing.LongHashFunction.NATIVE_LITTLE_ENDIAN;
import static net.openhft.hashing.Primitives.unsignedInt;

/**
 * Derived from https://github.com/google/guava/blob/fa95e381e665d8ee9639543b99ed38020c8de5ef
 * /guava/src/com/google/common/hash/Murmur3_128HashFunction.java
 */
class MurmurHash_3 {
    private static final MurmurHash_3 INSTANCE = new MurmurHash_3();

    private static final MurmurHash_3 NATIVE_MURMUR = NATIVE_LITTLE_ENDIAN ?
            MurmurHash_3.INSTANCE : BigEndian.INSTANCE;

    private static final long C1 = 0x87c37b91114253d5L;
    private static final long C2 = 0x4cf5ad432745937fL;

    private MurmurHash_3() {}

    <T> long fetch64(Access<T> access, T in, long off) {
        return access.getLong(in, off);
    }

    <T> int fetch32(Access<T> access, T in, long off) {
        return access.getInt(in, off);
    }

    long toLittleEndian(long v) {
        return v;
    }

    int toLittleEndian(int v) {
        return v;
    }

    int toLittleEndianShort(int unsignedShort) {
        return unsignedShort;
    }

    public <T> long hash(long seed, T input, Access<T> access, long offset, long length) {
        long h1 = seed;
        long h2 = seed;
        long remaining = length;
        while (remaining >= 16L) {
            long k1 = fetch64(access, input, offset);
            long k2 = fetch64(access, input, offset + 8L);
            offset += 16L;
eclipse.ast.parser.InstrumentationTemplate.instrum(" line number " + " | " + 66 + " | " + "offset += 16L;" + " | " + "src\\main\\java\\net" + " | " + " ASSIGNMENT " + " | " +  " offset = " + offset + " | " +  " 16L = " + 16L);

eclipse.ast.parser.InstrumentationTemplate.instrum(" line number " + 66 + " ASSIGNMENT " +  " offset = " + offset +  " 16L = " + 16L);

            remaining -= 16L;
eclipse.ast.parser.InstrumentationTemplate.instrum(" line number " + " | " + 69 + " | " + "remaining -= 16L;" + " | " + "src\\main\\java\\net" + " | " + " ASSIGNMENT " + " | " +  " 16L = " + 16L + " | " +  " remaining = " + remaining);

eclipse.ast.parser.InstrumentationTemplate.instrum(" line number " + 67 + " ASSIGNMENT " +  " 16L = " + 16L +  " remaining = " + remaining);

            h1 ^= mixK1(k1);
eclipse.ast.parser.InstrumentationTemplate.instrum(" line number " + " | " + 72 + " | " + "h1 ^= mixK1(k1);" + " | " + "src\\main\\java\\net" + " | " + " ASSIGNMENT " + " | " +  " k1 = " + k1 + " | " +  " h1 = " + h1);

eclipse.ast.parser.InstrumentationTemplate.instrum(" line number " + 68 + " ASSIGNMENT " +  " k1 = " + k1 +  " h1 = " + h1);


            h1 = Long.rotateLeft(h1, 27);
            h1 += h2;
eclipse.ast.parser.InstrumentationTemplate.instrum(" line number " + " | " + 77 + " | " + "h1 += h2;" + " | " + "src\\main\\java\\net" + " | " + " ASSIGNMENT " + " | " +  " h1 = " + h1 + " | " +  " h2 = " + h2);

eclipse.ast.parser.InstrumentationTemplate.instrum(" line number " + 71 + " ASSIGNMENT " +  " h1 = " + h1 +  " h2 = " + h2);

            h1 = h1 * 5L + 0x52dce729L;
eclipse.ast.parser.InstrumentationTemplate.instrum(" line number " + " | " + 80 + " | " + "h1 = h1 * 5L + 0x52dce729L;" + " | " + "src\\main\\java\\net" + " | " + " ASSIGNMENT " + " | " +  " 0x52dce729L = " + 0x52dce729L + " | " +  " 5L = " + 5L + " | " +  " h1 = " + h1);

eclipse.ast.parser.InstrumentationTemplate.instrum(" line number " + 72 + " ASSIGNMENT " +  " 0x52dce729L = " + 0x52dce729L +  " 5L = " + 5L +  " h1 = " + h1);


            h2 ^= mixK2(k2);
eclipse.ast.parser.InstrumentationTemplate.instrum(" line number " + " | " + 84 + " | " + "h2 ^= mixK2(k2);" + " | " + "src\\main\\java\\net" + " | " + " ASSIGNMENT " + " | " +  " k2 = " + k2 + " | " +  " h2 = " + h2);

eclipse.ast.parser.InstrumentationTemplate.instrum(" line number " + 74 + " ASSIGNMENT " +  " k2 = " + k2 +  " h2 = " + h2);


            h2 = Long.rotateLeft(h2, 31);
            h2 += h1;
eclipse.ast.parser.InstrumentationTemplate.instrum(" line number " + " | " + 89 + " | " + "h2 += h1;" + " | " + "src\\main\\java\\net" + " | " + " ASSIGNMENT " + " | " +  " h1 = " + h1 + " | " +  " h2 = " + h2);

eclipse.ast.parser.InstrumentationTemplate.instrum(" line number " + 77 + " ASSIGNMENT " +  " h1 = " + h1 +  " h2 = " + h2);

            h2 = h2 * 5L + 0x38495ab5L;
eclipse.ast.parser.InstrumentationTemplate.instrum(" line number " + " | " + 92 + " | " + "h2 = h2 * 5L + 0x38495ab5L;" + " | " + "src\\main\\java\\net" + " | " + " ASSIGNMENT " + " | " +  " 5L = " + 5L + " | " +  " 0x38495ab5L = " + 0x38495ab5L + " | " +  " h2 = " + h2);

eclipse.ast.parser.InstrumentationTemplate.instrum(" line number " + 78 + " ASSIGNMENT " +  " 5L = " + 5L +  " 0x38495ab5L = " + 0x38495ab5L +  " h2 = " + h2);

        }

        if (remaining > 0L) {
            long k1 = 0L;
            long k2 = 0L;
            switch ((int) remaining) {
                case 15:
                    k2 ^= ((long) access.getUnsignedByte(input, offset + 14L)) << 48;// fall through
                case 14:
                    k2 ^= ((long) access.getUnsignedByte(input, offset + 13L)) << 40;// fall through
                case 13:
                    k2 ^= ((long) access.getUnsignedByte(input, offset + 12L)) << 32;// fall through
                case 12:
                    k2 ^= ((long) access.getUnsignedByte(input, offset + 11L)) << 24;// fall through
                case 11:
                    k2 ^= ((long) access.getUnsignedByte(input, offset + 10L)) << 16;// fall through
                case 10:
                    k2 ^= ((long) access.getUnsignedByte(input, offset + 9L)) << 8; // fall through
                case 9:
                    k2 ^= ((long) access.getUnsignedByte(input, offset + 8L)); // fall through
                case 8:
                    k1 ^= fetch64(access, input, offset);
                    break;
                case 7:
                    k1 ^= ((long) access.getUnsignedByte(input, offset + 6L)) << 48; // fall through
                case 6:
                    k1 ^= ((long) access.getUnsignedByte(input, offset + 5L)) << 40; // fall through
                case 5:
                    k1 ^= ((long) access.getUnsignedByte(input, offset + 4L)) << 32; // fall through
                case 4:
                    k1 ^= Primitives.unsignedInt(fetch32(access, input, offset));
                    break;
                case 3:
                    k1 ^= ((long) access.getUnsignedByte(input, offset + 2L)) << 16; // fall through
                case 2:
                    k1 ^= ((long) access.getUnsignedByte(input, offset + 1L)) << 8; // fall through
                case 1:
                    k1 ^= ((long) access.getUnsignedByte(input, offset));
                case 0:
                    break;
                default:
                    throw new AssertionError("Should never get here.");
            }
            h1 ^= mixK1(k1);
eclipse.ast.parser.InstrumentationTemplate.instrum(" line number " + " | " + 72 + " | " + "h1 ^= mixK1(k1);" + " | " + "src\\main\\java\\net" + " | " + " ASSIGNMENT " + " | " +  " k1 = " + k1 + " | " +  " h1 = " + h1);

eclipse.ast.parser.InstrumentationTemplate.instrum(" line number " + 68 + " ASSIGNMENT " +  " k1 = " + k1 +  " h1 = " + h1);

            h2 ^= mixK2(k2);
eclipse.ast.parser.InstrumentationTemplate.instrum(" line number " + " | " + 84 + " | " + "h2 ^= mixK2(k2);" + " | " + "src\\main\\java\\net" + " | " + " ASSIGNMENT " + " | " +  " k2 = " + k2 + " | " +  " h2 = " + h2);

eclipse.ast.parser.InstrumentationTemplate.instrum(" line number " + 74 + " ASSIGNMENT " +  " k2 = " + k2 +  " h2 = " + h2);

        }


        return finalize(length, h1, h2);
    }

    private static long finalize(long length, long h1, long h2) {
        h1 ^= length;
eclipse.ast.parser.InstrumentationTemplate.instrum(" line number " + " | " + 151 + " | " + "h1 ^= length;" + " | " + "src\\main\\java\\net" + " | " + " ASSIGNMENT " + " | " +  " length = " + length + " | " +  " h1 = " + h1);

eclipse.ast.parser.InstrumentationTemplate.instrum(" line number " + 199 + " ASSIGNMENT " +  " length = " + length +  " h1 = " + h1);

        h2 ^= length;
eclipse.ast.parser.InstrumentationTemplate.instrum(" line number " + " | " + 154 + " | " + "h2 ^= length;" + " | " + "src\\main\\java\\net" + " | " + " ASSIGNMENT " + " | " +  " length = " + length + " | " +  " h2 = " + h2);

eclipse.ast.parser.InstrumentationTemplate.instrum(" line number " + 200 + " ASSIGNMENT " +  " length = " + length +  " h2 = " + h2);


        h1 += h2;
eclipse.ast.parser.InstrumentationTemplate.instrum(" line number " + " | " + 77 + " | " + "h1 += h2;" + " | " + "src\\main\\java\\net" + " | " + " ASSIGNMENT " + " | " +  " h1 = " + h1 + " | " +  " h2 = " + h2);

eclipse.ast.parser.InstrumentationTemplate.instrum(" line number " + 71 + " ASSIGNMENT " +  " h1 = " + h1 +  " h2 = " + h2);

        h2 += h1;
eclipse.ast.parser.InstrumentationTemplate.instrum(" line number " + " | " + 89 + " | " + "h2 += h1;" + " | " + "src\\main\\java\\net" + " | " + " ASSIGNMENT " + " | " +  " h1 = " + h1 + " | " +  " h2 = " + h2);

eclipse.ast.parser.InstrumentationTemplate.instrum(" line number " + 77 + " ASSIGNMENT " +  " h1 = " + h1 +  " h2 = " + h2);


        h1 = fmix64(h1);
eclipse.ast.parser.InstrumentationTemplate.instrum(" line number " + " | " + 165 + " | " + "h1 = fmix64(h1);" + " | " + "src\\main\\java\\net" + " | " + " ASSIGNMENT " + " | " +  " h1 = " + h1);

eclipse.ast.parser.InstrumentationTemplate.instrum(" line number " + 205 + " ASSIGNMENT " +  " h1 = " + h1);

        h2 = fmix64(h2);
eclipse.ast.parser.InstrumentationTemplate.instrum(" line number " + " | " + 168 + " | " + "h2 = fmix64(h2);" + " | " + "src\\main\\java\\net" + " | " + " ASSIGNMENT " + " | " +  " h2 = " + h2);

eclipse.ast.parser.InstrumentationTemplate.instrum(" line number " + 206 + " ASSIGNMENT " +  " h2 = " + h2);


        h1 += h2;
eclipse.ast.parser.InstrumentationTemplate.instrum(" line number " + " | " + 77 + " | " + "h1 += h2;" + " | " + "src\\main\\java\\net" + " | " + " ASSIGNMENT " + " | " +  " h1 = " + h1 + " | " +  " h2 = " + h2);

eclipse.ast.parser.InstrumentationTemplate.instrum(" line number " + 71 + " ASSIGNMENT " +  " h1 = " + h1 +  " h2 = " + h2);

        return h1;
    }

    private static long fmix64(long k) {
        k ^= k >>> 33;
eclipse.ast.parser.InstrumentationTemplate.instrum(" line number " + " | " + 179 + " | " + "k ^= k >>> 33;" + " | " + "src\\main\\java\\net" + " | " + " ASSIGNMENT " + " | " +  " k = " + k);

eclipse.ast.parser.InstrumentationTemplate.instrum(" line number " + 213 + " ASSIGNMENT " +  " k = " + k);

        k *= 0xff51afd7ed558ccdL;
eclipse.ast.parser.InstrumentationTemplate.instrum(" line number " + " | " + 182 + " | " + "k *= 0xff51afd7ed558ccdL;" + " | " + "src\\main\\java\\net" + " | " + " ASSIGNMENT " + " | " +  " 0xff51afd7ed558ccdL = " + 0xff51afd7ed558ccdL + " | " +  " k = " + k);

eclipse.ast.parser.InstrumentationTemplate.instrum(" line number " + 214 + " ASSIGNMENT " +  " 0xff51afd7ed558ccdL = " + 0xff51afd7ed558ccdL +  " k = " + k);

        k ^= k >>> 33;
eclipse.ast.parser.InstrumentationTemplate.instrum(" line number " + " | " + 179 + " | " + "k ^= k >>> 33;" + " | " + "src\\main\\java\\net" + " | " + " ASSIGNMENT " + " | " +  " k = " + k);

eclipse.ast.parser.InstrumentationTemplate.instrum(" line number " + 213 + " ASSIGNMENT " +  " k = " + k);

        k *= 0xc4ceb9fe1a85ec53L;
eclipse.ast.parser.InstrumentationTemplate.instrum(" line number " + " | " + 188 + " | " + "k *= 0xc4ceb9fe1a85ec53L;" + " | " + "src\\main\\java\\net" + " | " + " ASSIGNMENT " + " | " +  " 0xc4ceb9fe1a85ec53L = " + 0xc4ceb9fe1a85ec53L + " | " +  " k = " + k);

eclipse.ast.parser.InstrumentationTemplate.instrum(" line number " + 216 + " ASSIGNMENT " +  " 0xc4ceb9fe1a85ec53L = " + 0xc4ceb9fe1a85ec53L +  " k = " + k);

        k ^= k >>> 33;
eclipse.ast.parser.InstrumentationTemplate.instrum(" line number " + " | " + 179 + " | " + "k ^= k >>> 33;" + " | " + "src\\main\\java\\net" + " | " + " ASSIGNMENT " + " | " +  " k = " + k);

eclipse.ast.parser.InstrumentationTemplate.instrum(" line number " + 213 + " ASSIGNMENT " +  " k = " + k);

        return k;
    }

    private static long mixK1(long k1) {
        k1 *= C1;
eclipse.ast.parser.InstrumentationTemplate.instrum(" line number " + " | " + 198 + " | " + "k1 *= C1;" + " | " + "src\\main\\java\\net" + " | " + " ASSIGNMENT " + " | " +  " k1 = " + k1 + " | " +  " private static final long C1 = " + C1);

eclipse.ast.parser.InstrumentationTemplate.instrum(" line number " + 222 + " ASSIGNMENT " +  " k1 = " + k1 +  " private static final long C1 = " + C1);

        k1 = Long.rotateLeft(k1, 31);
        k1 *= C2;
eclipse.ast.parser.InstrumentationTemplate.instrum(" line number " + " | " + 202 + " | " + "k1 *= C2;" + " | " + "src\\main\\java\\net" + " | " + " ASSIGNMENT " + " | " +  " k1 = " + k1 + " | " +  " private static final long C2 = " + C2);

eclipse.ast.parser.InstrumentationTemplate.instrum(" line number " + 224 + " ASSIGNMENT " +  " k1 = " + k1 +  " private static final long C2 = " + C2);

        return k1;
    }

    private static long mixK2(long k2) {
        k2 *= C2;
eclipse.ast.parser.InstrumentationTemplate.instrum(" line number " + " | " + 209 + " | " + "k2 *= C2;" + " | " + "src\\main\\java\\net" + " | " + " ASSIGNMENT " + " | " +  " k2 = " + k2 + " | " +  " private static final long C2 = " + C2);

eclipse.ast.parser.InstrumentationTemplate.instrum(" line number " + 229 + " ASSIGNMENT " +  " k2 = " + k2 +  " private static final long C2 = " + C2);

        k2 = Long.rotateLeft(k2, 33);
        k2 *= C1;
eclipse.ast.parser.InstrumentationTemplate.instrum(" line number " + " | " + 213 + " | " + "k2 *= C1;" + " | " + "src\\main\\java\\net" + " | " + " ASSIGNMENT " + " | " +  " k2 = " + k2 + " | " +  " private static final long C1 = " + C1);

eclipse.ast.parser.InstrumentationTemplate.instrum(" line number " + 231 + " ASSIGNMENT " +  " k2 = " + k2 +  " private static final long C1 = " + C1);

        return k2;
    }

    private static class BigEndian extends MurmurHash_3 {
        private static final BigEndian INSTANCE = new BigEndian();
        private BigEndian() {}

        @Override
        <T> long fetch64(Access<T> access, T in, long off) {
            return reverseBytes(super.fetch64(access, in, off));
        }

        @Override
        <T> int fetch32(Access<T> access, T in, long off) {
            return Integer.reverseBytes(super.fetch32(access, in, off));
        }

        @Override
        long toLittleEndian(long v) {
            return reverseBytes(v);
        }

        @Override
        int toLittleEndian(int v) {
            return Integer.reverseBytes(v);
        }

        @Override
        int toLittleEndianShort(int unsignedShort) {
            return ((unsignedShort & 0xFF) << 8) | (unsignedShort >> 8);
        }
    }

    private static class AsLongHashFunction extends LongHashFunction {
        public static final AsLongHashFunction INSTANCE = new AsLongHashFunction();
        private static final long serialVersionUID = 0L;

        private Object readResolve() {
            return INSTANCE;
        }

        long seed() {
            return 0L;
        }

        long hashNativeLong(long nativeLong, long len) {
            long h1 = mixK1(nativeLong);
            long h2 = 0L;
            return MurmurHash_3.finalize(len, h1, h2);
        }

        @Override
        public long hashLong(long input) {
            return hashNativeLong(NATIVE_MURMUR.toLittleEndian(input), 8L);
        }

        @Override
        public long hashInt(int input) {
            return hashNativeLong(unsignedInt(NATIVE_MURMUR.toLittleEndian(input)), 4L);
        }

        @Override
        public long hashShort(short input) {
            return hashNativeLong(
                    (long) NATIVE_MURMUR.toLittleEndianShort(Primitives.unsignedShort(input)), 2L);
        }

        @Override
        public long hashChar(char input) {
            return hashNativeLong((long) NATIVE_MURMUR.toLittleEndianShort((int) input), 2L);
        }

        @Override
        public long hashByte(byte input) {
            return hashNativeLong((long) Primitives.unsignedByte((int) input), 1L);
        }

        @Override
        public long hashVoid() {
            return 0L;
        }

        @Override
        public <T> long hash(T input, Access<T> access, long off, long len) {
            long seed = seed();
            if (access.byteOrder(input) == LITTLE_ENDIAN) {
                return MurmurHash_3.INSTANCE.hash(seed, input, access, off, len);
            } else {
                return BigEndian.INSTANCE.hash(seed, input, access, off, len);
            }
        }
    }

    public static LongHashFunction asLongHashFunctionWithoutSeed() {
        return AsLongHashFunction.INSTANCE;
    }

    private static class AsLongHashFunctionSeeded extends AsLongHashFunction {
        private static final long serialVersionUID = 0L;

        private final long seed;
        private transient long voidHash;

        private AsLongHashFunctionSeeded(long seed) {
            this.seed = seed;
            voidHash = MurmurHash_3.finalize(0L, seed, seed);
        }

        @Override
        long seed() {
            return seed;
        }

        @Override
        long hashNativeLong(long nativeLong, long len) {
            long seed = this.seed;
            long h1 = seed ^ mixK1(nativeLong);
            long h2 = seed;
            return MurmurHash_3.finalize(len, h1, h2);
        }

        @Override
        public long hashVoid() {
            return voidHash;
        }
    }

    public static LongHashFunction asLongHashFunctionWithSeed(long seed) {
        return new AsLongHashFunctionSeeded(seed);
    }
}