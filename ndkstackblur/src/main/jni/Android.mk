LOCAL_PATH:= $(call my-dir)

include $(CLEAR_VARS)

LOCAL_CFLAGS   := -D_ARM_ASSEM_ -fvisibility=hidden -O3 -ffast-math -W -Wall
LOCAL_ARM_MODE := arm
LOCAL_LDLIBS   += -llog -ljnigraphics
LOCAL_SRC_FILES :=  blur.c

LOCAL_MODULE := libstackblur

include $(BUILD_SHARED_LIBRARY)
