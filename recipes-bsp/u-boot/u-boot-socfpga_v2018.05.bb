require u-boot-socfpga-common.inc
require u-boot-socfpga-boot-script.inc
require ${COREBASE}/meta/recipes-bsp/u-boot/u-boot.inc

FILESEXTRAPATHS =. "${THISDIR}/files/v2018.05:"
FILESEXTRAPATHS =. "${THISDIR}/u-boot:"

SRCREV = "890e79f2b1c26c5ba1a86d179706348aec7feef7"

RC_URI_append = "\
    file://0001-sockit-settings-to-quartus-handoff.patch \
        "

# Some versions of u-boot use .bin and others use .img.
# By default we use .sfp as this is what is generated
# for Cyclone V by the U-Boot.
UBOOT_SUFFIX = "sfp"
UBOOT_BINARY = "u-boot-with-spl.${UBOOT_SUFFIX}"

UBOOT_MAKE_TARGET ?= "all"

DEPENDS += "dtc-native bc-native u-boot-mkimage-native"
