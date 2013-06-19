#!/bin/bash
DISK=$1
FS=$2

echo "
About to formated a drive for booting to a beaglebone. This is an inherintely
dangerous operation since it over writes a drive. Make sure everything looks
ok in this script and your input before using this script. The drive to work on
is $DISK 

"

BOOTP="$DISK""1"
ROOTFS="$DISK""2"

mount_check=`mount | grep $DISK`
if [ -n "$mount_check" ] 
then
 echo "the disk may be mounted"
 exit
fi

echo "starting to format, continue? (^C to cancel)"
# format with 128MB Fat32 partition, marked bootable
# another partition to take up the rest of the space
sfdisk $DISK -u M << EOF
,128,0b,*
,,L
EOF
echo "formatting complete"
echo "making filesystems.. (this can take a while for large disks)"

echo "boot partition on $BOOTP"
echo "rootfs partition on $ROOTFS"
mkfs.vfat -F 32 -n "boot" $BOOTP
mkfs.ext3 -L "rootfs" $ROOTFS

echo "
Now copying boot files over "
mkdir /mnt/boot/
mkdir /mnt/rootfs/

mount $BOOTP /mnt/boot
mount $ROOTFS /mnt/rootfs

cp MLO /mnt/boot/MLO
cp u-boot.img /mnt/boot/u-boot.img
cp uImage /mnt/boot/uImage

echo "Now extracting the root filesystem"
tar xvf $FS -C $ROOTFS

umount $BOOTP
umount $ROOTFS
echo "All done, eject the drive and it should boot"

