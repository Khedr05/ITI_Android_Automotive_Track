# Compiler
CC = gcc

# Directories
SRC_DIR = src
INC_DIR = include
BIN_DIR = bin
BUILD_DIR = build

# Target executable
TARGET = calculator

#Flags
CFLAGS = -I$(INC_DIR)

# Source files
SRCS = $(wildcard $(SRC_DIR)/*.c)

# Object files
OBJS = $(foreach src_file,$(SRCS),$(BIN_DIR)/$(notdir $(src_file:.c=.o)))

# Default target
all: $(BUILD_DIR)/$(TARGET)

# Linking the target executable
$(BUILD_DIR)/$(TARGET): $(OBJS) | $(BUILD_DIR)
	$(CC) -o $@ $^

# Compiling individual source files into object files
$(BIN_DIR)/%.o: $(SRC_DIR)/%.c | $(BIN_DIR)
	$(CC) $(CFLAGS) -c $< -o $@

# Create necessary directories if they don't exist
$(BIN_DIR):
	mkdir -p $(BIN_DIR)

$(BUILD_DIR):
	mkdir -p $(BUILD_DIR)

# Clean up build artifacts
clean:
	rm -rf $(BUILD_DIR) $(BIN_DIR)

# Declare phony targets
.PHONY: all clean
