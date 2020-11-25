#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_rong_laboratory_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_rong_laboratory_MainActivity_stringFromJNI2(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++ from JNI2";
    return env->NewStringUTF(hello.c_str());
}
