###########################################################
# Additional boot script recipe
###########################################################
# Source for script
SRC_URI_append = " file://aux-boot-script.txt"

# Destination to be used by Build system and by U-Boot environment
UBOOT_ENV = "cyclone5"
UBOOT_ENV_SUFFIX = "scr"
###########################################################

###########################################################
# Additional tasks to be performed
###########################################################
do_compile_append () {
    mkimage \
    -A arm -O linux -T script -C none -a 0 -e 0 -n "SocKit AUX Boot script" \
    -d ${WORKDIR}/aux-boot-script.txt \
    ${WORKDIR}/${UBOOT_ENV}.${UBOOT_ENV_SUFFIX}
}

do_deploy_append () {
    # Deploy Aux boot script for sd card
    install ${WORKDIR}/aux-boot-script.txt ${DEPLOYDIR}
}

