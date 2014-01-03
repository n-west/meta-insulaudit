# Image for insulaudit, based on Angstrom's systemd-image. 
# Include some extra networking tools and usb drivers and utilities.

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

IMAGE_FEATURES = "ssh-server-openssh \
                package-management \
                "

IMAGE_INSTALL = "packagegroup-core-boot \
                packagegroup-core-ssh-openssh \
                ${ROOTFS_PKGMANAGE_BOOTSTRAP} \
                ${CORE_IMAGE_EXTRA_INSTALL} \
                systemd-analyze \
                "

# We want some extras
IMAGE_INSTALL += "socat usb-modeswitch ppp curl avahi \
		cmgpy insulware \
        vim screen git "

IMAGE_DEV_MANAGER   = "udev"
IMAGE_INIT_MANAGER  = "systemd"
IMAGE_INITSCRIPTS   = " "
IMAGE_LOGIN_MANAGER = "busybox shadow"

export IMAGE_BASENAME = "insulaudit-image"

inherit core-image
