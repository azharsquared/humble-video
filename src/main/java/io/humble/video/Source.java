/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.0
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.humble.video;
import io.humble.ferry.*;
/**
 * A Source of {@link Packet} data.  
 */
public class Source extends Container {
  @Override
  public String toString() {
    final StringBuilder b = new StringBuilder(super.toString());
    b.append("[")
    .append("url="+getURL()+";")
    .append("format:"+getSourceFormat()+";")
    .append("]");
    return b.toString();
  }
  // JNIHelper.swg: Start generated code
  // >>>>>>>>>>>>>>>>>>>>>>>>>>>
  /**
   * This method is only here to use some references and remove
   * a Eclipse compiler warning.
   */
  @SuppressWarnings("unused")
  private void noop()
  {
    Buffer.make(null, 1);
  }
   
  private volatile long swigCPtr;

  /**
   * Internal Only.
   */
  protected Source(long cPtr, boolean cMemoryOwn) {
    super(VideoJNI.SWIGSourceUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }
  
  /**
   * Internal Only.
   */
  protected Source(long cPtr, boolean cMemoryOwn,
      java.util.concurrent.atomic.AtomicLong ref)
  {
    super(VideoJNI.SWIGSourceUpcast(cPtr),
     cMemoryOwn, ref);
    swigCPtr = cPtr;
  }
    
  /**
   * Internal Only.  Not part of public API.
   *
   * Get the raw value of the native object that obj is proxying for.
   *   
   * @param obj The java proxy object for a native object.
   * @return The raw pointer obj is proxying for.
   */
  protected static long getCPtr(Source obj) {
    if (obj == null) return 0;
    return obj.getMyCPtr();
  }

  /**
   * Internal Only.  Not part of public API.
   *
   * Get the raw value of the native object that we're proxying for.
   *   
   * @return The raw pointer we're proxying for.
   */  
  protected long getMyCPtr() {
    if (swigCPtr == 0) throw new IllegalStateException("underlying native object already deleted");
    return swigCPtr;
  }
  
  /**
   * Create a new Source object that is actually referring to the
   * exact same underlying native object.
   *
   * @return the new Java object.
   */
  @Override
  public Source copyReference() {
    if (swigCPtr == 0)
      return null;
    else
      return new Source(swigCPtr, swigCMemOwn, getJavaRefCount());
  }

  /**
   * Compares two values, returning true if the underlying objects in native code are the same object.
   *
   * That means you can have two different Java objects, but when you do a comparison, you'll find out
   * they are the EXACT same object.
   *
   * @return True if the underlying native object is the same.  False otherwise.
   */
  public boolean equals(Object obj) {
    boolean equal = false;
    if (obj instanceof Source)
      equal = (((Source)obj).swigCPtr == this.swigCPtr);
    return equal;
  }
  
  /**
   * Get a hashable value for this object.
   *
   * @return the hashable value.
   */
  public int hashCode() {
     return (int)swigCPtr;
  }
  
  // <<<<<<<<<<<<<<<<<<<<<<<<<<<
  // JNIHelper.swg: End generated code
  

/**
 * Create a new {@link Source}  
 */
  public static Source make() {
    long cPtr = VideoJNI.Source_make();
    return (cPtr == 0) ? null : new Source(cPtr, false);
  }

/**
 * {@inheritDoc}  
 */
  protected ContainerFormat getFormat() {
    long cPtr = VideoJNI.Source_getFormat(swigCPtr, this);
    return (cPtr == 0) ? null : new ContainerFormat(cPtr, false);
  }

/**
 * {@inheritDoc}  
 */
  public Container.State getState() {
    return Container.State.swigToEnum(VideoJNI.Source_getState(swigCPtr, this));
  }

/**
 *  
 * or null if unknown.  
 */
  public SourceFormat getSourceFormat() {
    long cPtr = VideoJNI.Source_getSourceFormat(swigCPtr, this);
    return (cPtr == 0) ? null : new SourceFormat(cPtr, false);
  }

/**
 * Set the buffer length Humble Video will suggest to FFMPEG for reading 
 * inputs.  
 * If called when a Container is open, the call is ignored and -1 is 
 * returned.  
 * @param	size The suggested buffer size.  
 * @throws	InvalidArgument if size <= 0  
 */
  public void setInputBufferLength(int size) {
    VideoJNI.Source_setInputBufferLength(swigCPtr, this, size);
  }

/**
 * Return the input buffer length.  
 * @return	The input buffer length Humble Video told FFMPEG to assume. 
 *		  
 * 0 means FFMPEG should choose it's own  
 * size (and it'll probably be 32768).  
 */
  public int getInputBufferLength() {
    return VideoJNI.Source_getInputBufferLength(swigCPtr, this);
  }

/**
 * Open this container and make it ready for reading, optionally  
 * reading as far into the container as necessary to find all streams. 
 *  
 * <p>The caller must call {@link #close()} when done, but if not, the 
 *  
 * {@link Source} will eventually close  
 * them later but warn to the logging system.  
 * </p><p>If the current thread is interrupted while this blocking method 
 *  
 * is running the method will return with a negative value.  
 * To check if the method exited because of an interruption  
 * pass the return value to {@link Error#make(int)} and then  
 * check {@link Error#getType()} to see if it is  
 * {@link Error.Type#ERROR_INTERRUPTED}.  
 * </p>  
 * @param	url The resource to open; The format of this string is any 
 *		  
 * url that FFMPEG supports (including additional protocols if added 
 *  
 * through the video.customio library).  
 * @param	type The type of this container.  
 * @param	format A pointer to a InputFormat object specifying  
 * the format of this container, or null if you want us to guess.  
 * @param	streamsCanBeAddedDynamically If true, open() will expect that 
 *		 new  
 * streams can be added at any time, even after the format header has 
 * been read.  
 * @param	queryStreamMetaData If true, open() will call {@link #queryStreamMetaData()} 
 *		  
 * on this container, which will potentially block until it has ready 
 *  
 * enough data to find all streams in a container. If false, it will 
 * only  
 * block to read a minimal header for this container format.  
 * @param	options If not null, a set of key-value pairs that will be 
 *		 set on the container immediately  
 * the format is determined. Some options cannot be set on input formats 
 * until  
 * the system has had a chance to determine what the format is, so this 
 *  
 * is the only way to set InputFormat-specific options.  
 * @param	optionsNotSet If not null, on return this {@link KeyValueBag} 
 *		 object will be cleared out, and  
 * replace with any key/value pairs that were in <code>options</code> 
 * but could not be set on this  
 * {@link Source}.  
 * @return	>= 0 on success; < 0 on error.  
 */
  public void open(String url, SourceFormat format, boolean streamsCanBeAddedDynamically, boolean queryStreamMetaData, KeyValueBag options, KeyValueBag optionsNotSet) throws java.lang.InterruptedException, java.io.IOException {
    VideoJNI.Source_open(swigCPtr, this, url, SourceFormat.getCPtr(format), format, streamsCanBeAddedDynamically, queryStreamMetaData, KeyValueBag.getCPtr(options), options, KeyValueBag.getCPtr(optionsNotSet), optionsNotSet);
  }

/**
 * Close the container. open() must have been called first, or  
 * else an error is returned.  
 * <p>If the current thread is interrupted while this blocking method 
 *  
 * is running the method will return with a negative value.  
 * To check if the method exited because of an interruption  
 * pass the return value to {@link Error#make(int)} and then  
 * check {@link Error#getType()} to see if it is  
 * {@link Error.Type#ERROR_INTERRUPTED}.  
 * </p>  
 * <p>  
 * If this method exits because of an interruption,  
 * all resources will be closed anyway.  
 * </p>  
 */
  public void close() throws java.lang.InterruptedException, java.io.IOException {
    VideoJNI.Source_close(swigCPtr, this);
  }

/**
 * Get the stream at the given position.  
 * @param	streamIndex the index of this stream in the container  
 * @return	The stream at that position in the container, or null if 
 *		 none there.  
 */
  public SourceStream getSourceStream(int streamIndex) throws java.lang.InterruptedException, java.io.IOException {
    long cPtr = VideoJNI.Source_getSourceStream(swigCPtr, this, streamIndex);
    return (cPtr == 0) ? null : new SourceStream(cPtr, false);
  }

/**
 * Reads the next packet in the Source into the Packet. This method 
 * will  
 * release any buffers currently held by this packet and allocate  
 * new ones.  
 * <p>If the current thread is interrupted while this blocking method 
 *  
 * is running the method will return with a negative value.  
 * To check if the method exited because of an interruption  
 * pass the return value to {@link Error#make(int)} and then  
 * check {@link Error#getType()} to see if it is  
 * {@link Error.Type#ERROR_INTERRUPTED}.  
 * </p>  
 * @param	packet [In/Out] The packet the Source will read into.  
 * @return	0 if successful, or <0 if not.  
 */
  public int read(MediaPacket packet) throws java.lang.InterruptedException, java.io.IOException {
    return VideoJNI.Source_read(swigCPtr, this, MediaPacket.getCPtr(packet), packet);
  }

/**
 * Attempts to read all the meta data in this stream, potentially by 
 * reading ahead  
 * and decoding packets.  
 * <p>  
 * Any packets this method reads ahead will be cached and correctly 
 * returned when you  
 * read packets, but this method can be non-blocking potentially until 
 * end of container  
 * to get all meta data. Take care when you call it.  
 * </p><p>After this method is called, other meta data methods like 
 * {@link #getDuration()} should  
 * work.</p> <p>If the current thread is interrupted while this blocking 
 * method  
 * is running the method will return with a negative value.  
 * To check if the method exited because of an interruption  
 * pass the return value to {@link Error#make(int)} and then  
 * check {@link Error#getType()} to see if it is  
 * {@link Error.Type#ERROR_INTERRUPTED}.  
 * </p>  
 */
  public void queryStreamMetaData() throws java.lang.InterruptedException, java.io.IOException {
    VideoJNI.Source_queryStreamMetaData(swigCPtr, this);
  }

/**
 * Gets the duration, if known, of this container.  
 * This will only work for non-streamable containers where Source  
 * can calculate the container size.  
 * @return	The duration, or {@link Global#NO_PTS} if not known.  
 */
  public long getDuration() {
    return VideoJNI.Source_getDuration(swigCPtr, this);
  }

/**
 * Get the starting timestamp in microseconds of the first packet of 
 * the earliest stream in this container.  
 * <p>  
 * This will only return value values either either (a) for non-streamable 
 *  
 * containers where Source can calculate the container size or  
 * (b) after Source has actually read the  
 * first packet from a streamable source.  
 * </p>  
 * @return	The starting timestamp in microseconds, or {@link Global#NO_PTS} 
 *		 if not known.  
 */
  public long getStartTime() {
    return VideoJNI.Source_getStartTime(swigCPtr, this);
  }

/**
 * Get the file size in bytes of this container.  
 * This will only return a valid value if the container is non-streamed 
 * and supports seek.  
 * @return	The file size in bytes, or <0 on error.  
 */
  public long getFileSize() {
    return VideoJNI.Source_getFileSize(swigCPtr, this);
  }

/**
 * Get the calculated overall bit rate of this file.  
 * <p>  
 * This will only return a valid value if the container is non-streamed 
 * and supports seek.  
 * </p>  
 * @return	The overall bit rate in bytes per second, or <0 on error. 
 *		  
 */
  public int getBitRate() {
    return VideoJNI.Source_getBitRate(swigCPtr, this);
  }

/**
 * Get the flags associated with this object.  
 * @return	The (compacted) value of all flags set.  
 */
  public int getFlags() {
    return VideoJNI.Source_getFlags(swigCPtr, this);
  }

/**
 * Set the flags to use with this object. All values  
 * must be ORed (|) together.  
 * @see		Flags  
 * @param	newFlags The new set flags for this codec.  
 */
  public void setFlags(int newFlags) {
    VideoJNI.Source_setFlags(swigCPtr, this, newFlags);
  }

/**
 * Get the setting for the specified flag  
 * @param	flag The flag you want to find the setting for  
 * @return	0 for false; non-zero for true  
 */
  public boolean getFlag(Container.Flag flag) {
    return VideoJNI.Source_getFlag(swigCPtr, this, flag.swigValue());
  }

/**
 * Set the flag.  
 * @param	flag The flag to set  
 * @param	value The value to set it to (true or false)  
 */
  public void setFlag(Container.Flag flag, boolean value) {
    VideoJNI.Source_setFlag(swigCPtr, this, flag.swigValue(), value);
  }

/**
 * Get the URL the Source was opened with.  
 * May return null if unknown.  
 * @return	the URL opened, or null.  
 */
  public String getURL() {
    return VideoJNI.Source_getURL(swigCPtr, this);
  }

/**
 * Get the number of times {@link Source#readNextPacket(Packet)}  
 * will retry a read if it gets a {@link Error.Type#ERROR_AGAIN}  
 * value back.  
 * Defaults to 1 times. <0 means it will keep retrying indefinitely. 
 *  
 * @return	the read retry count  
 */
  public int getReadRetryCount() {
    return VideoJNI.Source_getReadRetryCount(swigCPtr, this);
  }

/**
 * Sets the read retry count.  
 * @see		#getReadRetryCount()  
 * @param	count The read retry count. <0 means keep trying.  
 */
  public void setReadRetryCount(int count) {
    VideoJNI.Source_setReadRetryCount(swigCPtr, this, count);
  }

/**
 * Can streams be added dynamically to this container?  
 * @return	true if streams can be added dynamically  
 */
  public boolean canStreamsBeAddedDynamically() {
    return VideoJNI.Source_canStreamsBeAddedDynamically(swigCPtr, this);
  }

/**
 * Get the {@link KeyValueBag} of media MetaData for this object,  
 * or null if none.  
 * <p>  
 * If the {@link Source} or {@link IStream} object  
 * that this {@link KeyValueBag} came from was opened  
 * for reading, then changes via {@link KeyValueBag#setValue(String, 
 * String)}  
 * will have no effect on the underlying media.  
 * </p>  
 * <p>  
 * If the {@link Source} or {@link IStream} object  
 * that this {@link KeyValueBag} came from was opened  
 * for writing, then changes via {@link KeyValueBag#setValue(String, 
 * String)}  
 * will have no effect after {@link Source#writeHeader()}  
 * is called.  
 * </p>  
 * @return	the {@link KeyValueBag}.  
 */
  public KeyValueBag getMetaData() {
    long cPtr = VideoJNI.Source_getMetaData(swigCPtr, this);
    return (cPtr == 0) ? null : new KeyValueBag(cPtr, false);
  }

/**
 * Forces the {@link Source} to assume all audio streams are  
 * encoded with the given audio codec when demuxing.  
 * @param	id The codec id  
 * @return	< 0 on error (e.g. not an audio codec); >= 0 on success. 
 *		  
 */
  public int setForcedAudioCodec(Codec.ID id) {
    return VideoJNI.Source_setForcedAudioCodec(swigCPtr, this, id.swigValue());
  }

/**
 * Forces the {@link Source} to assume all video streams are  
 * encoded with the given video codec when demuxing.  
 * @param	id The codec id  
 * @return	< 0 on error (e.g. not an video codec); >= 0 on success. 
 *		  
 */
  public int setForcedVideoCodec(Codec.ID id) {
    return VideoJNI.Source_setForcedVideoCodec(swigCPtr, this, id.swigValue());
  }

/**
 * Forces the {@link Source} to assume all subtitle streams are  
 * encoded with the given subtitle codec when demuxing.  
 * @param	id The codec id  
 * @return	< 0 on error (e.g. not an subtitle codec); >= 0 on success. 
 *		  
 */
  public int setForcedSubtitleCodec(Codec.ID id) {
    return VideoJNI.Source_setForcedSubtitleCodec(swigCPtr, this, id.swigValue());
  }

/**
 * Seek to timestamp ts.  
 * Seeking will be done so that the point from which all active streams 
 *  
 * can be presented successfully will be closest to ts and within min/max_ts. 
 *  
 * Active streams are all streams that have {@link Stream.getDiscardSetting} 
 * <  
 * {@link Codec.DISCARD_ALL}.  
 * If flags contain {@link SeekFlags.SEEK_BYTE}, then all timestamps 
 * are in bytes and  
 * are the file position (this may not be supported by all demuxers). 
 *  
 * If flags contain {@link SeekFlags.SEEK_FRAME}, then all timestamps 
 * are in frames  
 * in the stream with stream_index (this may not be supported by all 
 * demuxers).  
 * Otherwise all timestamps are in units of the stream selected by stream_index 
 *  
 * or if stream_index is -1, in (1/Global.DEFAULT_PTS_MICROSECONDS} 
 * units.  
 * If flags contain {@link SeekFlags.SEEK_ANY}, then non-keyframes are 
 * treated as  
 * keyframes (this may not be supported by all demuxers).  
 * @param	stream_index index of the stream which is used as time base 
 *		 reference  
 * @param	min_ts smallest acceptable timestamp  
 * @param	ts target timestamp  
 * @param	max_ts largest acceptable timestamp  
 * @param	flags flags  
 * @return	>=0 on success, error code otherwise  
 * 
 * Thus do not use this yet. It may change at any time, do not expect 
 *  
 * ABI compatibility yet!  
 */
  public int seek(int stream_index, long min_ts, long ts, long max_ts, int flags) throws java.lang.InterruptedException, java.io.IOException {
    return VideoJNI.Source_seek(swigCPtr, this, stream_index, min_ts, ts, max_ts, flags);
  }

/**
 * Gets the AVFormatContext.max_delay property if possible.  
 * @return	The max delay, error code otherwise.  
 */
  public int getMaxDelay() {
    return VideoJNI.Source_getMaxDelay(swigCPtr, this);
  }

/**
 *  
 */
  public void play() throws java.lang.InterruptedException, java.io.IOException {
    VideoJNI.Source_play(swigCPtr, this);
  }

/**
 * Pause a playing network source. Call {@link #play()} to unpause. 
 *  
 * @return	0 on success; <0 if state is not {@link #State.STATE_PLAYING} 
 *		 or error.  
 */
  public void pause() throws java.lang.InterruptedException, java.io.IOException {
    VideoJNI.Source_pause(swigCPtr, this);
  }

  public enum SeekFlag {
  /**
   * Flags that can be bitmasked in the {@link #seek} method. If no
   * flag, then key-frame-only/forward seeking is assumed.
   * Seek backwards.
   */
    SEEK_BACKWARD(VideoJNI.Source_SEEK_BACKWARD_get()),
  /**
   * Seek based on position in bytes.
   */
    SEEK_BYTE(VideoJNI.Source_SEEK_BYTE_get()),
  /**
   * Seek to any frame, even non-keyframes
   */
    SEEK_ANY(VideoJNI.Source_SEEK_ANY_get()),
  /**
   * Seek based on frame number
   */
    SEEK_FRAME(VideoJNI.Source_SEEK_FRAME_get());

    public final int swigValue() {
      return swigValue;
    }

    public static SeekFlag swigToEnum(int swigValue) {
      SeekFlag[] swigValues = SeekFlag.class.getEnumConstants();
      if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
        return swigValues[swigValue];
      for (SeekFlag swigEnum : swigValues)
        if (swigEnum.swigValue == swigValue)
          return swigEnum;
      throw new IllegalArgumentException("No enum " + SeekFlag.class + " with value " + swigValue);
    }

    @SuppressWarnings("unused")
    private SeekFlag() {
      this.swigValue = SwigNext.next++;
    }

    @SuppressWarnings("unused")
    private SeekFlag(int swigValue) {
      this.swigValue = swigValue;
      SwigNext.next = swigValue+1;
    }

    @SuppressWarnings("unused")
    private SeekFlag(SeekFlag swigEnum) {
      this.swigValue = swigEnum.swigValue;
      SwigNext.next = this.swigValue+1;
    }

    private final int swigValue;

    private static class SwigNext {
      private static int next = 0;
    }
  }

}
